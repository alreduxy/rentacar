package com.aaldama.rentacar.service.impl;

import com.aaldama.rentacar.dto.VehicleRentalDTO;
import com.aaldama.rentacar.model.RentalStatus;
import com.aaldama.rentacar.model.Vehicle;
import com.aaldama.rentacar.model.VehicleRental;
import com.aaldama.rentacar.repo.RentalStatusRepo;
import com.aaldama.rentacar.repo.VehicleRentalRepo;
import com.aaldama.rentacar.repo.VehicleRepo;
import com.aaldama.rentacar.service.VehicleRentalService;
import com.aaldama.rentacar.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ValidationException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleRentalServiceImpl implements VehicleRentalService {

    private final VehicleRentalRepo vehicleRentalRepo;

    private final VehicleRepo vehicleRepo;

    private final RentalStatusRepo rentalStatusRepo;

    @Autowired
    public VehicleRentalServiceImpl(VehicleRentalRepo vehicleRentalRepo, VehicleRepo vehicleRepo, RentalStatusRepo rentalStatusRepo) {
        this.vehicleRentalRepo = vehicleRentalRepo;
        this.vehicleRepo = vehicleRepo;
        this.rentalStatusRepo = rentalStatusRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleRental> findAll() {
        return vehicleRentalRepo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<VehicleRental> findById(Integer id) {
        return vehicleRentalRepo.findById(id);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @Override
    public VehicleRental save(VehicleRental vehicleRental) throws Exception {

        String validar = Utils.validarModelos(vehicleRental);

        Vehicle vehicle = null;

        if (validar.isEmpty()) {
            if (LocalDate.parse(vehicleRental.getDateFrom().toString())
                    .isAfter(LocalDate.parse(vehicleRental.getDateTo().toString()))) {
                throw new ValidationException("Date from cannot be greater than date to");
            }

            vehicle = vehicleRepo.findById(vehicleRental.getVehicle().getIdVehicle()).orElse(null);

            if (vehicleRepo.findByIdVehicle(vehicle.getIdVehicle()) == null) {
                throw new UsernameNotFoundException("The vehicle id does not exist");
            }

            if (vehicle.getRentalStatus().getIdRentalStatus() == RentalStatus.NOT_AVAILABLE) {
                throw new UsernameNotFoundException("The vehicle id is not available, check another date from " + vehicleRental.getDateTo());
            }
        }

        vehicleRental.setQuantityDays(Utils.getQuantityDays(vehicleRental.getDateFrom(), vehicleRental.getDateTo()));
        vehicleRental.setTotalPrice(Utils.getTotalPrice(vehicleRental.getQuantityDays(), vehicle.getDailyHireRate()));
        VehicleRental vehicleRentalNuevo = vehicleRentalRepo.save(vehicleRental);

        if (vehicleRentalNuevo.getIdVehicleRental() != 0) {
            RentalStatus rentalStatus = rentalStatusRepo.getById(RentalStatus.NOT_AVAILABLE);
            vehicle.setRentalStatus(rentalStatus);
            updateVehicle(vehicle);
        }

        return vehicleRentalNuevo;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        vehicleRentalRepo.deleteById(id);
    }

    @Override
    public List<VehicleRentalDTO> listVehicleByUserId(int idUser) {
        List<VehicleRentalDTO> listaVehiculos = new ArrayList<>();
        vehicleRentalRepo.listVehicleByUserId(idUser).forEach(x -> {
            VehicleRentalDTO dto = new VehicleRentalDTO();
            dto.setFullName(String.valueOf(x[0]));
            dto.setEmail(String.valueOf(x[1]));
            dto.setPhone(String.valueOf(x[2]));
            dto.setLocationName(String.valueOf(x[3]));
            dto.setVehicleTypeDescription(String.valueOf(x[4]));
            dto.setModelName(String.valueOf(x[5]));
            dto.setDailyHireRate(Long.parseLong(String.valueOf(x[6])));
            dto.setManufacturerName(String.valueOf(x[7]));
            dto.setCurrentKilometers(Integer.valueOf(String.valueOf(x[8])));
            dto.setPlate(String.valueOf(x[9]));
            dto.setColor(String.valueOf(x[10]));
            dto.setDateFrom(String.valueOf(x[11]));
            dto.setDateTo(String.valueOf(x[12]));
            dto.setQuantityDays(Integer.valueOf(String.valueOf(x[13])));
            dto.setTotalPrice(Integer.parseInt(String.valueOf(x[14])));

            listaVehiculos.add(dto);
        });
        return listaVehiculos;

    }
}
