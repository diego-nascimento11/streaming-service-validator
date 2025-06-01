package application;

import java.util.ArrayList;
import java.util.List;

import model.entities.*;

/**
 * Sistema de Validação de Usuários para Serviço de Streaming
 * <p>
 * Este sistema valida o acesso de usuários baseado em critérios específicos:
 * - Usuários premium: acesso garantido
 * - Usuários não-premium: devem ter idade >= 16, conta verificada e pagamento em dia
 *
 * @author Diego Oliveira
 */

public class Main {
    public static void main(String[] args) {

        // Criação da lista para armazenar todos os usuários do sistema
        List<User> users = new ArrayList<>();

        // Usuários originais - casos de teste variados
        users.add(new User("Paulo", 15, false, true, false));      // Premium menor de idade
        users.add(new User("Ana", 19, true, false, true));         // Não-premium com acesso
        users.add(new User("Diego", 12, false, false, true));      // Menor de idade, múltiplos problemas
        users.add(new User("André", 14, false, true, false));      // Premium menor de idade
        users.add(new User("Antônio", 12, true, false, true));     // Muito novo, mas outros requisitos ok
        users.add(new User("Gabriel", 23, true, false, false));    // Adulto com pagamento atrasado
        users.add(new User("Pedro", 19, true, false, true));       // Não-premium com acesso
        users.add(new User("José", 14, false, false, false));      // Menor, múltiplos problemas
        users.add(new User("Maria", 17, false, false, false));     // Adolescente com múltiplos problemas
        users.add(new User("Pietro", 18, true, true, true));       // Premium com tudo ok
        users.add(new User("Lucas", 22, true, true, true));        // Premium adulto completo
        users.add(new User("Fernanda", 16, true, false, true));    // Idade mínima exata
        users.add(new User("Rafael", 13, false, false, false));    // Criança sem acesso
        users.add(new User("Isabella", 25, true, true, false));    // Premium com pagamento atrasado
        users.add(new User("Mateus", 20, false, false, true));     // Conta não verificada
        users.add(new User("Camila", 17, true, false, false));     // Adolescente, pagamento pendente
        users.add(new User("Thiago", 15, false, true, true));      // Premium menor de idade
        users.add(new User("Juliana", 24, true, false, true));     // Adulta não-premium com acesso
        users.add(new User("Felipe", 11, true, false, true));      // Criança muito nova
        users.add(new User("Amanda", 28, false, true, true));      // Premium sem verificação
        users.add(new User("Bruno", 16, true, false, true));       // Idade mínima, acesso liberado
        users.add(new User("Larissa", 21, true, true, false));     // Premium com pagamento atrasado
        users.add(new User("Gustavo", 14, false, false, true));    // Menor com conta não verificada
        users.add(new User("Beatriz", 18, true, false, false));    // Maior de idade, pagamento pendente
        users.add(new User("Vinicius", 26, false, false, false));  // Adulto com múltiplos problemas
        users.add(new User("Sophia", 19, true, true, true));       // Premium jovem adulta completa
        users.add(new User("Leonardo", 13, false, true, false));   // Premium criança
        users.add(new User("Mariana", 27, true, false, true));     // Adulta não-premium com acesso
        users.add(new User("João", 16, false, false, true));       // Idade mínima, conta não verificada
        users.add(new User("Valentina", 22, true, true, true));    // Premium adulta completa

        // Loop principal: processa cada usuário e exibe resultado da validação
        for (User c : users) {
            System.out.println("Usuário: " + c.getName());
            // Verifica se o usuário tem acesso ao sistema
            if (c.hasAccess()) {
                if (c.isPremium()) {
                    System.out.println("✅ Acesso autorizado. (Usuário é premium).");
                } else {
                    System.out.println("✅ Acesso autorizado.");
                }
            } else {
                // Acesso negado - lista todos os motivos específicos
                System.out.println("❌ Acesso negado.");
                System.out.println("Motivos:");
                // Obtém lista detalhada dos problemas que impedem o acesso
                List<String> reasons = c.getReasonsForDenial();
                for (String motivos : reasons) {
                    System.out.println(motivos);
                }
            }
            System.out.println(); // Linha em branco para separar usuários
        }
    }
}
