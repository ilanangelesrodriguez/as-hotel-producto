package com.arquitectura.ashotelproducto.presentacion;

import com.arquitectura.ashotelproducto.datos.cliente.ClienteDAOImpl;
import com.arquitectura.ashotelproducto.datos.habitacion.HabitacionDAOImpl;
import com.arquitectura.ashotelproducto.datos.otros.TurnoDAOImpl;
import com.arquitectura.ashotelproducto.datos.reserva.TipoReservaDAOImpl;
import com.arquitectura.ashotelproducto.dominio.Cliente;
import com.arquitectura.ashotelproducto.dominio.ClienteBusinessLogic;
import com.arquitectura.ashotelproducto.dominio.habitacion.Habitacion;
import com.arquitectura.ashotelproducto.dominio.habitacion.HabitacionBusinessLogic;
import com.arquitectura.ashotelproducto.dominio.reserva.Reserva;
import com.arquitectura.ashotelproducto.dominio.reserva.ReservaBusinessLogic;
import com.arquitectura.ashotelproducto.datos.reserva.ReservaDAOImpl;
import com.arquitectura.ashotelproducto.dominio.reserva.TipoReserva;
import com.arquitectura.ashotelproducto.dominio.reserva.TipoReservaBusinessLogic;
import com.arquitectura.ashotelproducto.dominio.turno.Turno;
import com.arquitectura.ashotelproducto.dominio.turno.TurnoBusinessLogic;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Named
@RequestScoped
public class ReservaBean {
    private Reserva reserva;
    private ReservaBusinessLogic reservaBL;
    private List<Reserva> reservas;
    private List<Habitacion> habitaciones;
    private List<Turno> turnos;
    private List<TipoReserva> tiposReserva;
    private String dniCliente;
    private String message;

    public ReservaBean() throws SQLException {
        reserva = new Reserva();
        reservaBL = new ReservaBusinessLogic(new ReservaDAOImpl());
        HabitacionBusinessLogic habitacionBL = new HabitacionBusinessLogic(new HabitacionDAOImpl());
        TurnoBusinessLogic turnoBL = new TurnoBusinessLogic(new TurnoDAOImpl());
        TipoReservaBusinessLogic tipoReservaBL = new TipoReservaBusinessLogic(new TipoReservaDAOImpl());

        List<Reserva> todasLasReservas = reservaBL.buscarTodasReservas();
        reservas = todasLasReservas;
        if (!todasLasReservas.isEmpty()) {
            Reserva ultimaReserva = todasLasReservas.stream()
                    .max(Comparator.comparing(Reserva::getIdReserva))
                    .orElseThrow(SQLException::new);
            reserva.setIdReserva(ultimaReserva.getIdReserva() + 1);
        } else {
            reserva.setIdReserva(1); // Valor predeterminado si no hay reservas en la base de datos
        }

        // Estos valores se llenarán en la vista
        reserva.setIdHabitacion(1);
        reserva.setIdTurno(1);
        reserva.setIdTipoReserva(String.valueOf(1));
        reserva.setFechaIngreso(new Date());

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 30);
        reserva.setFechaFin(calendar.getTime());

        // Asignar las listas obtenidas a las variables de instancia
        this.habitaciones = habitacionBL.obtenerTodasLasHabitaciones();
        this.turnos = turnoBL.obtenerTodosLosTurno();
        this.tiposReserva = tipoReservaBL.obtenerTodosLosTipoReserva();

        // Mover el bloque de código aquí
        ClienteBusinessLogic clienteBL = new ClienteBusinessLogic(new ClienteDAOImpl());
        Cliente cliente = clienteBL.buscarPorDni(dniCliente);
        if (cliente == null) {
            cliente = new Cliente();
            cliente.setDni(dniCliente);
            clienteBL.guardarCliente(cliente);
        }
        reserva.setIdCliente(cliente.getIdCliente());
    }

    public String getDniCliente() {
        return dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public ReservaBusinessLogic getReservaBL() {
        return reservaBL;
    }

    public void setReservaBL(ReservaBusinessLogic reservaBL) {
        this.reservaBL = reservaBL;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(List<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }

    public List<TipoReserva> getTiposReserva() {
        return tiposReserva;
    }

    public void setTiposReserva(List<TipoReserva> tiposReserva) {
        this.tiposReserva = tiposReserva;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void ingresar() {
        try {
            reservaBL.guardarReserva(reserva);
            message = "Reserva registrada con éxito.";
        } catch (Exception e) {
            message = "Error al registrar la reserva: " + e.getMessage();
        }
    }
}