package trabdb4o;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class BancoDeDados{
    
    Clientes cliente = new Clientes();
    ObjectContainer db;
    
    // MÉTODOS PARA MOSTRAR CLIENTES CADASTRADOS
    public String verTodosClientes(){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        while (lista.hasNext()){
            cliente = lista.next();
            
            System.out.println("##############");
            System.out.println(cliente.getId());
            System.out.println(cliente.getNome());
            System.out.println(cliente.getCpf());
            System.out.println(cliente.getGmail());
            System.out.println(cliente.getSenha());
        }
        
        db.close();
        
        return "";
    }
    
    public boolean verClientesId(int id){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setId(id);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getId() == buscar[i].getId()){
                System.out.println(buscar[i].getId());
                System.out.println(buscar[i].getNome());
                System.out.println(buscar[i].getCpf());
                System.out.println(buscar[i].getGmail());
                System.out.println(buscar[i].getSenha());
                
                db.close();
                
                return true;
            }
        }
        
        db.close();
        
        return false;
    }
    
    public boolean verClientesCPF(String cpf){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setCpf(cpf);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())){
                System.out.println(buscar[i].getId());
                System.out.println(buscar[i].getNome());
                System.out.println(buscar[i].getCpf());
                System.out.println(buscar[i].getGmail());
                System.out.println(buscar[i].getSenha());
                
                db.close();
                
                return true;
            }
        }
        
        db.close();
        
        return false;
    }
    
    public boolean verClientesGmail(String gmail){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setGmail(gmail);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getGmail().equals(buscar[i].getGmail())){
                System.out.println(buscar[i].getId());
                System.out.println(buscar[i].getNome());
                System.out.println(buscar[i].getCpf());
                System.out.println(buscar[i].getGmail());
                System.out.println(buscar[i].getSenha());
                
                db.close();
                
                return true;
            }
        }
        
        db.close();
        
        return false;
    }
    
    // MÉTODO PARA ADICIONAR NOVO CLIENTE
    public boolean addCliente(String nome, String cpf, String gmail, String senha){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setNome(nome);
        cliente.setCpf(cpf);
        cliente.setGmail(gmail);
        cliente.setSenha(senha);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())
                || cliente.getGmail().equals(buscar[i].getGmail())){
                // CLIENTE JÁ POSSUI UM CADASTRO
                db.close();
                
                return false;
            }
        }
        
        cliente.setId(cliente.getId() + 1);
        
        db.store(cliente);
        db.close();
        //CLIENTE CADASTRADO
        
        return true;
    }
    
    // MÉTODO PARA DELETAR CADASTRO
    public boolean delete(String cpf, String gmail){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setCpf(cpf);
        cliente.setGmail(gmail);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())
                && cliente.getGmail().equals(buscar[i].getGmail())){
                // CADASTRO DELETADO
                db.delete(buscar[i]);
                db.close();
                
                return true;
            }
        }
        // CADASTRO NÃO FOI DELETADO
        db.close();
        
        return false;
    }
    
    // MÉTODOS PARA ALTERAR CADASTROS
    public boolean verificarUpdate(String cpf, String gmail){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setCpf(cpf);
        cliente.setGmail(gmail);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())
                && cliente.getGmail().equals(buscar[i].getGmail())){
                db.close();
                
                return true;
            }
        }
        db.close();
        
        return false;
    }
    
    public void updateNome(String cpf, String gmail, String novoNome){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setCpf(cpf);
        cliente.setGmail(gmail);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())
                && cliente.getGmail().equals(buscar[i].getGmail())){
                
                cliente.setId(buscar[i].getId());
                cliente.setNome(novoNome);
                cliente.setCpf(buscar[i].getCpf());
                cliente.setGmail(buscar[i].getGmail());
                cliente.setSenha(buscar[i].getSenha());
                
                db.delete(buscar[i]);
                db.store(cliente);
                
                db.close();
                
                break;
            }
        }
    }
    
    public void updateGmail(String cpf, String gmail, String novoGmail){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setCpf(cpf);
        cliente.setGmail(gmail);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())
                && cliente.getGmail().equals(buscar[i].getGmail())){
                
                cliente.setId(buscar[i].getId());
                cliente.setNome(buscar[i].getNome());
                cliente.setCpf(buscar[i].getCpf());
                cliente.setGmail(novoGmail);
                cliente.setSenha(buscar[i].getSenha());
                
                db.delete(buscar[i]);
                db.store(cliente);
                
                db.close();
                
                break;
            }
        }
    }
    
    public void updateSenha(String cpf, String gmail, String novaSenha){
        db = Db4o.openFile("databaseDb4o");
        
        ObjectSet<Clientes> lista;
        lista = db.query(Clientes.class);
        
        Clientes buscar[] = new Clientes[lista.size()];
        
        cliente.setCpf(cpf);
        cliente.setGmail(gmail);
        
        for (int i = 0; i < lista.size(); i++){
            buscar[i] = lista.next();
            
            if (cliente.getCpf().equals(buscar[i].getCpf())
                && cliente.getGmail().equals(buscar[i].getGmail())){
                
                cliente.setId(buscar[i].getId());
                cliente.setNome(buscar[i].getNome());
                cliente.setCpf(buscar[i].getCpf());
                cliente.setGmail(buscar[i].getGmail());
                cliente.setSenha(novaSenha);
                
                db.delete(buscar[i]);
                db.store(cliente);
                
                db.close();
                
                break;
            }
        }
    }
        
}//public class BancoDeDados