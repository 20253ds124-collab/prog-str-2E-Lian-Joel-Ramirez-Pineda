package com.example.demolistviewvalidacionedad.services;
import com.example.demolistviewvalidacionedad.repositories.PersonFileRepository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonService {

    PersonFileRepository repo =new PersonFileRepository();


    public List<String> loadDataForListView() throws IOException {

        List<String> lines= repo.readAllLines();
        List<String> result= new ArrayList<>();

        for(String line: lines){
            if(line==null || line.isBlank()) continue;

            String[] parts= line.split(",");
            if (parts.length <3 )continue;
            String name= parts[0];
            String email=parts[1];
            String age=parts[2];
            result.add(name+ " , " + email + " , "+ age);
        }
        return result;
    }

    public void updatePerson(int index, String name, String email, int edad) throws IOException {
        validate(name, email, edad);
        if (index<0){
            throw new IllegalArgumentException("El indice es invalido");
        }
        List<String> data=getCleanLines();
        data.set(index, name + " , "+ email+ " , "+ edad);
        repo.saveFile(data);

    }


    public void deletePerson(int index) throws IOException{
        List<String> data = getCleanLines();

        if (index < 0 || index >= data.size()) {
            throw new IllegalArgumentException("Índice inválido");
        }

        data.remove(index);
        repo.saveFile(data);
    }
        private List<String> getCleanLines() throws IOException {
            List<String> lines=repo.readAllLines();
            List<String> cleanLines= new ArrayList<>();
            for (String line: lines){
                if (line!=null && !line.isBlank()){
                    cleanLines.add(line);
                }
            }
            return cleanLines;
        }




    public void addPerson(String name, String email, int age) throws IOException {
        validate(name, email, age);
        repo.appendNewLine(name+"," + email + "," + age);
    }
    private void validate(String name, String email, int age ){
        if(name==null || name.isBlank() || name.length()<3){
            throw new IllegalArgumentException("El nombre es incorrecto");
        }
        String em= (email==null) ? "" : email.trim();
        if(em.isBlank() || !em.contains("@") || !em.contains(".")){
            throw new IllegalArgumentException("El email es incorrecto");
        }
        if(age < 18){
            throw new IllegalArgumentException("La edad debe ser mayor a 18 años");
        }
    }
}
