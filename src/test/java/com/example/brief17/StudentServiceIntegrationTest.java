package com.example.brief17;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;

import com.example.brief17.entity.Student;
import com.example.brief17.service.StudentService;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

// TODO: Ajouter les tags nécessaires pour charger H2, charger le profil de test et importer le StudentService

@DataJpaTest
@Import(StudentService.class) // Importer le StudentService
@ActiveProfiles("test")
class StudentServiceIntegrationTest {
@Autowired
private StudentService studentService;

    @Test
    void shouldSaveAndRetrieveStudent() {
        // TODO: Implémenter le test d'intégration, insérer un Student en base de données et le récupérer
        Student student1 = new Student();
        student1.setName("a");
        student1.setAddress("b");

        Student resultStudent = studentService.saveStudent(student1);

        Optional<Student> savedStudent1 = studentService.findStudentById(resultStudent.getId());

        assertTrue(savedStudent1.isPresent());
        assertThat(savedStudent1.get().getName()).isEqualTo("a");
        assertThat(savedStudent1.get().getAddress()).isEqualTo("b");


    }
}