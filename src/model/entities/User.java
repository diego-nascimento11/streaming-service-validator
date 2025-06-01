package model.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um usuário do serviço de streaming
 *
 * Contém informações pessoais e de conta necessárias para validação de acesso:
 * - Dados pessoais: nome e idade
 * - Status da conta: verificação, premium e situação do pagamento
 *
 * @author Diego Oliveira
 */

public class User {

    // Atributos privados - encapsulamento
    private String name;              // Nome do usuário
    private int age;                  // Idade em anos
    private boolean verifiedAccount;  // Se a conta foi verificada
    private boolean premium;          // Se possui assinatura premium
    private boolean paymentUpToDate;  // Se o pagamento está em dia

    /**
     * Construtor da classe User
     *
     * @param name Nome do usuário
     * @param age Idade do usuário
     * @param verifiedAccount Se a conta foi verificada (email, telefone, etc.)
     * @param premium Se possui assinatura premium ativa
     * @param paymentUpToDate Se o pagamento está em dia (sem pendências)
     */
    public User(String name, int age, boolean verifiedAccount, boolean premium, boolean paymentUpToDate) {
        this.name = name;
        this.age = age;
        this.verifiedAccount = verifiedAccount;
        this.premium = premium;
        this.paymentUpToDate = paymentUpToDate;
    }

    // Métodos getters - acesso controlado aos atributos privados
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isVerifiedAccount() {
        return verifiedAccount;
    }

    public boolean isPremium() {
        return premium;
    }

    public boolean isPaymentUpToDate() {
        return paymentUpToDate;
    }


    /**
     * Método principal de validação de acesso
     *
     * Regras de negócio:
     * - Usuários premium: acesso garantido independente de outros fatores
     * - Usuários não-premium: devem atender TODOS os critérios:
     *   * Idade mínima de 16 anos
     *   * Conta verificada
     *   * Pagamento em dia
     *
     * @return true se o usuário tem acesso, false caso contrário
     */
    public boolean hasAcces() {
        // Premium bypassa todas as validações - acesso garantido
        if (premium) {
            return true;
        }
        // Para não-premium: todas as condições devem ser verdadeiras
        return age >= 16 && verifiedAccount && paymentUpToDate;
    }

    /**
     * Gera lista detalhada dos motivos que impedem o acesso
     *
     * Analisa cada critério não atendido para usuários não-premium
     * e retorna lista de strings explicativas para feedback ao usuário
     *
     * @return Lista de strings com os motivos de negação de acesso
     */
    public List<String> getReasonsForDenial() {
        List<String> reasons = new ArrayList<>();

        // Só verifica problemas se não for premium
        // (premium sempre tem acesso, logo não há motivos para negação)
        if (!premium) {
            // Verifica cada critério individualmente
            if (age < 16) {
                reasons.add("- Idade inferior a 16.");
            }
            if (!verifiedAccount) {
                reasons.add("- Conta não verificada.");
            }
            if (!paymentUpToDate) {
                reasons.add("- Pagamento em atraso.");
            }
        }
        return reasons;
    }
}
