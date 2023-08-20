package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Api.ApiResponse;
import com.example.schoolmanagement.DTO.AddressDTO;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressserivce;

    @GetMapping("/")
    public ResponseEntity getAddress(){
        return  ResponseEntity.status(HttpStatus.OK).body(addressserivce.getAddress());
    }
    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO address){
        addressserivce.addAdress(address);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address added"));
    }
    @DeleteMapping("/delete/{addressId}")
    public ResponseEntity removeAddress(@PathVariable Integer addressId){
        addressserivce.removeAdress(addressId);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address deleted"));
    }
    @PutMapping("/update")
    public ResponseEntity updateAddress(@RequestBody @Valid AddressDTO address){
        addressserivce.updateAddress(address);
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("address updated"));
    }
    @GetMapping("/search/{teacherId}")
    public ResponseEntity searchById(@PathVariable Integer teacherId){
     return ResponseEntity.status(HttpStatus.OK).body(addressserivce.getAddressById(teacherId));
    }

}
