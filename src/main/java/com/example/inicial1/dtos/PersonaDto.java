package com.example.inicial1.dtos;


import com.example.inicial1.entities.Persona;
import com.example.inicial1.repositories.BaseRepository;
import lombok.*;
import org.modelmapper.ModelMapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class PersonaDto {

    private Long id;
    private String nombre;
    private String apellido;



}
