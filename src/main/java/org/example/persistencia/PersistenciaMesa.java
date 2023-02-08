package org.example.persistencia;

import org.example.entidade.Mesa;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class PersistenciaMesa {

    private ArrayList<Mesa> listaMesas;

    private static PersistenciaMesa instance;

    public static PersistenciaMesa  getInstance(){
        if(Objects.isNull(instance)){
            instance = new PersistenciaMesa ();
        }
        return instance;
    }

    private PersistenciaMesa(){
        listaMesas = new ArrayList<>();
    }


    public void adicionarMesa(Mesa mesa){
        if(Objects.isNull(listaMesas)){
            listaMesas = new ArrayList<>();
        }
        listaMesas.add(mesa);
    }

    public Optional<Mesa> buscarPorNumero(int numero) {
        for (Mesa mesa: listaMesas) {
            if(mesa.getNumero() == numero){
                return Optional.of(mesa);
            }
        }
        return Optional.empty();
    }

    public ArrayList<Mesa> getListaMesas() {
        return listaMesas;
    }

    public void imprimir(){
        for (Mesa mesa: listaMesas) {
            System.out.printf("Mesa %d: Jogadores: %d \n", mesa.getNumero(), mesa.getJogadoresNaMesa().size());
        }
    }
}
