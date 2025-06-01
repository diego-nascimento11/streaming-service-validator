# 🎬 Sistema de Validação de Usuários - Serviço de Streaming

Sistema em Java que valida o acesso de usuários a um serviço de streaming baseado em critérios específicos.

## 📋 Sobre o Projeto

Este projeto implementa um sistema de validação que verifica se usuários têm permissão para acessar conteúdo de um serviço de streaming. O sistema analisa diferentes critérios como idade, verificação da conta, status premium e situação do pagamento.

## 🔧 Funcionalidades

- **Validação de Acesso**: Verifica automaticamente se um usuário pode acessar o serviço
- **Sistema Premium**: Usuários premium têm acesso garantido independente de outros critérios
- **Relatório de Negação**: Lista motivos específicos quando o acesso é negado
- **Processamento em Massa**: Valida múltiplos usuários de uma vez

## 📊 Critérios de Validação

### Para usuários **não-premium**:
- ✅ Idade mínima de 16 anos
- ✅ Conta verificada
- ✅ Pagamento em dia

### Para usuários **premium**:
- ✅ Acesso liberado automaticamente

## 🚀 Como Executar

1. **Pré-requisitos**: Java 8 ou superior
2. **Compilar**: 
   ```bash
   javac application/Main.java model/entities/User.java
   ```
3. **Executar**:
   ```bash
   java application.Main
   ```

## 📁 Estrutura do Projeto

```
src/
├── application/
│   └── Main.java          # Classe principal com teste dos usuários
└── model/
    └── entities/
        └── User.java      # Classe User com lógica de validação
```

## 💻 Exemplo de Saída

```
Usuário: Paulo
✅ Acesso autorizado. (Usuário é premium).


Usuário: Ana
✅ Acesso autorizado.

Usuário: Diego
❌ Acesso negado.
Motivos:
- Idade inferior a 16.
- Conta não verificada.
```

## 🛠️ Tecnologias Utilizadas

- **Java** - Linguagem principal
- **Collections (ArrayList)** - Gerenciamento de listas
- **OOP** - Programação orientada a objetos

## 👨‍💻 Desenvolvido por

Diego Oliveira - Estudante de Análise e Desenvolvimento de Sistemas

---

> Este projeto faz parte do meu portfólio acadêmico e demonstra conhecimentos em Java, validação de regras de negócio e estruturas de dados.

## 📧 Contato
- LinkedIn: [Diego Oliveira] (https://www.linkedin.com/in/diego-oliveira-5333a4369/)
- Email: diegooliveira03333@gmail.com
- GitHub: [diego-nascimento11] (https://github.com/diego-nascimento11)
