package martin.dev.sweethair.controllers;

import lombok.AllArgsConstructor;
import martin.dev.sweethair.dtos.AppointmentDtoPost;
import martin.dev.sweethair.dtos.base.AppointmentDtoBase;
import martin.dev.sweethair.dtos.full.AppointmentDtoFull;
import martin.dev.sweethair.entities.Appointment;
import martin.dev.sweethair.services.AppointmentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/appointment")
@CrossOrigin
@AllArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final ModelMapper modelMapper;

    @GetMapping()
    public ResponseEntity<List<AppointmentDtoFull>> getAll() {
        List<AppointmentDtoFull> appointments = appointmentService.getAll().stream()
                .map(appointment -> modelMapper.map(appointment, AppointmentDtoFull.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AppointmentDtoBase> create(@RequestBody AppointmentDtoPost appointmentDtoPost) {
        Appointment appointment = appointmentService.save(appointmentDtoPost);
        AppointmentDtoBase appointmentDtoBase = modelMapper.map(appointment, AppointmentDtoBase.class);
        return new ResponseEntity<>(appointmentDtoBase, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AppointmentDtoFull> getById(@PathVariable("id") Long id) {
        Appointment appointment = appointmentService.getById(id);
        AppointmentDtoFull appointmentDtoFull = modelMapper.map(appointment, AppointmentDtoFull.class);
        return new ResponseEntity<>(appointmentDtoFull, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        appointmentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AppointmentDtoFull> updateById(@RequestBody AppointmentDtoPost appointmentDtoPost) {
        Appointment appointment = appointmentService.updateById(appointmentDtoPost);
        AppointmentDtoFull appointmentDtoFull = modelMapper.map(appointment, AppointmentDtoFull.class);
        return new ResponseEntity<>(appointmentDtoFull, HttpStatus.OK);
    }
}
