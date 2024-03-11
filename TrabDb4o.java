package trabdb4o;

import java.util.Scanner;

public class TrabDb4o {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        BancoDeDados bd = new BancoDeDados();
        
        int op = 0;
        
        while (op != 5){
            System.out.println("""
                                Digite 1: VER CLIENTES CADASTRADOS
                                Digite 2: ADICIONAR CLIENTE
                                Digite 3: ALTERAR CADASTRO
                                Digite 4: DELETAR CADASTRO
                                Digite 5: SAIR
                                   """);
                op = scan.nextInt();
            
            switch (op) {
                case 1: // VER CLIENTES CADASTRADOS
                    int visualizar;
                    
                    System.out.println("""
                                       Digite 1: VER TODOS CLIENTES CADASTRADO
                                       Digite 2: BUSCAR CADASTRO POR ID
                                       Digite 3: BUSCAR CADASTRO POR CPF
                                       Digite 4: BUSCAR CADASTRO POR GMAIL
                                       """);
                    visualizar = scan.nextInt();
                    
                    switch (visualizar) {
                        case 1:
                            bd.verTodosClientes();
                            
                            break;
                            
                        case 2:
                            System.out.println("Digite o id do cliente:");
                            bd.cliente.setId(scan.nextInt());
                            
                            if (bd.verClientesId(bd.cliente.getId()) == true){
                                System.out.println("");
                            } else {
                                System.out.println("ID do cliente não foi encontrado!");
                            }
                            
                            break;
                            
                        case 3:
                            System.out.println("Digite o cpf do cliente:");
                            bd.cliente.setCpf(scan.next());
                            
                            if (bd.verClientesCPF(bd.cliente.getCpf()) == true){
                                System.out.println("");
                            } else {
                                System.out.println("CPF do cliente não foi encontrado!");
                            }
                            
                            break;
                            
                        case 4:
                            System.out.println("Digite o gmail do cliente:");
                            bd.cliente.setGmail(scan.next());
                            
                            if (bd.verClientesCPF(bd.cliente.getCpf()) == true){
                                System.out.println("");
                            } else {
                                System.out.println("Gmail do cliente não foi encontrado!");
                            }
                            
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    
                    break;
                    
                case 2: // ADICIONAR CLIENTE
                    System.out.println("Digite o nome do cliente:");
                    bd.cliente.setNome(scan.next());
                    
                    System.out.println("Digite o cpf do cliente:");
                    bd.cliente.setCpf(scan.next());
                    
                    System.out.println("Digite o gmail do cliente:");
                    bd.cliente.setGmail(scan.next());
                    
                    System.out.println("Digite a senha do cliente:");
                    bd.cliente.setSenha(scan.next());
                    
                    if (bd.addCliente(bd.cliente.getNome(), bd.cliente.getCpf(), bd.cliente.getGmail(), bd.cliente.getSenha()) == true){
                        System.out.println("Cadastro concluído com sucesso!");
                    } else {
                        System.out.println("Este cliente já está cadastrado");
                    }
                    
                    break;
                    
                case 3: // ALTERAR CADASTRO
                    System.out.println("Digite o cpf do cliente:");
                    bd.cliente.setCpf(scan.next());
                    
                    System.out.println("Digite o gmail do cliente:");
                    bd.cliente.setGmail(scan.next());
                    
                    if (bd.verificarUpdate(bd.cliente.getCpf(), bd.cliente.getGmail()) == true){
                        int alterar = 0;
                        
                        System.out.println("""
                                           Digite 1: ALTERAR NOME
                                           Digite 2: ALTERAR GMAIL
                                           Digite 3: ALTERAR SENHA
                                           """);
                        alterar = scan.nextInt();
                        
                        switch (alterar) {
                            case 1:
                                System.out.println("Digite o novo nome:");
                                bd.cliente.setNome(scan.next());
                                
                                bd.updateNome(bd.cliente.getCpf(), bd.cliente.getGmail(), bd.cliente.getNome());
                                
                                System.out.println("Nome atualizado com sucesso!");
                                
                                break;
                                
                            case 2:
                                System.out.println("Digite o novo gmail:");
                                String novoGmail = scan.next();
                                
                                bd.updateGmail(bd.cliente.getCpf(), bd.cliente.getGmail(), novoGmail);
                                
                                System.out.println("Gmail atualizado com sucesso!");
                                
                                break;
                                
                            case 3:
                                System.out.println("Digite o nova senha:");
                                bd.cliente.setSenha(scan.next());
                                
                                bd.updateSenha(bd.cliente.getCpf(), bd.cliente.getGmail(), bd.cliente.getSenha());
                                
                                System.out.println("Senha atualizada com sucesso!");
                                
                                break;
                            default:
                                System.out.println("Opção inválida");
                        }
                    } else {
                        System.out.println("Cadastro não foi encontrado!");
                    }
                    
                    break;
                    
                case 4: // DELETAR CADASTRO
                    System.out.println("Digite o cpf do cliente:");
                    bd.cliente.setCpf(scan.next());
                    
                    System.out.println("Digite o gmail do cliente:");
                    bd.cliente.setGmail(scan.next());
                    
                    int confirmar ;
                    
                    System.out.println("""
                                       Digite 1: CONFIRMAR
                                       Digite 2: CANCELAR
                                       """);
                    confirmar = scan.nextInt();
                    
                    switch (confirmar) {
                        case 1:
                            if (bd.delete(bd.cliente.getCpf(), bd.cliente.getGmail()) == true){
                                System.out.println("Cadastro deletado com sucesso!");
                            } else {
                                System.out.println("Cadastro não encontrado!");
                            }
                            
                            break;
                            
                        case 2:
                            System.out.println("Cadastro do cliente não foi deletado!");
                            
                            break;
                        default:
                            System.out.println("Opção inválida");
                    }
                    
                    break;
                    
                case 5: // ENCERRAR PROGRAMA
                    System.out.println("Programa finalizado");
                    
                    break;
                
                default: // OPÇÃO INVÁLIDA
                    System.out.println("Opção inválida");
            }
        }
    }//public static void main(String[] args)
}//public class TrabDb4o
