
import model.Animal;
import model.ClienteDAO;
import model.Cliente;
import model.Endereco;
import model.Especie;
import java.util.List;
import model.AnimalDAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author g247468
 */
public class main {

    public static void main(String[] args) {

        Especie esp1 = new Especie(1, "Cachorro");
        Especie esp2 = new Especie(2, "Gato");

        Endereco end1 = new Endereco(1, "Turquia", "Vila Omar", "Americana", "13469094");

        ClienteDAO.create(1, 1, "Guilherme", "goulart.gritti@outlook.com");
        List<Cliente> clientes = ClienteDAO.retrieveAll();

        AnimalDAO.create(1, 1, 1, "Zeppelin", 6, 1);
        AnimalDAO.create(2, 1, 2, "Led", 3, 1);
        
        System.out.println("Todos Animais: ");
        List<Animal> todosAnimais = AnimalDAO.retrieveAll();

        for(Animal anm: todosAnimais){
            System.out.println("" + anm.getNome_animal());
        }
        
        Cliente cliSelecionado = ClienteDAO.retrieveById(1);
        
        List<Animal> animaisCliente = AnimalDAO.retrieveByIdCli(cliSelecionado.getId_cli());

        System.out.println("Animais desse cliente: ");
        
        for(Animal anm: animaisCliente){
            System.out.println("" + anm.getNome_animal());
        }

    }
}
