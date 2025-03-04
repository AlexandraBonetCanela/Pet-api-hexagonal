package edu.alexandra.pet.PetModule.domain.service;

import edu.alexandra.pet.PetModule.application.request.CreatePetRequest;
import edu.alexandra.pet.PetModule.domain.model.Pet;
import edu.alexandra.pet.PetModule.domain.model.PetType;
import edu.alexandra.pet.PetModule.domain.port.PetRepositoryPort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class PetServiceImplTest {

    @Mock
    private PetRepositoryPort petRepository;

    @InjectMocks
    private PetServiceImpl petService;

    @Test
    void createPet_validRequest_success() {

        CreatePetRequest request = new CreatePetRequest("1", "Manolito", PetType.BUS_STOP);
        Pet expectedPet = new Pet("Manolito", PetType.BUS_STOP);

        when(petRepository.createPet(any(Pet.class), eq("1"))).thenReturn(expectedPet);

        Pet result = petService.createPet(request);

        assertNotNull(result, "The created Pet should not be null");
        assertEquals("Manolito", result.getName(), "Pet name should match");
        assertEquals(PetType.BUS_STOP, result.getType(), "Pet type should match");

        ArgumentCaptor<Pet> petCaptor = ArgumentCaptor.forClass(Pet.class);
        verify(petRepository, times(1)).createPet(petCaptor.capture(), eq("1"));

        Pet capturedPet = petCaptor.getValue();
        assertEquals("Manolito", capturedPet.getName());
        assertEquals(PetType.BUS_STOP, capturedPet.getType());

    }


}
