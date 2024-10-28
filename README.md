![alt text](/src/ZIP/preview.png)

# FindMyAddress

Esta é uma aplicação em Java desenvolvida utilizando o framework WindowBuilder no Eclipse IDE. O objetivo da aplicação é permitir que os usuários busquem informações de endereço com base em um Código de Endereçamento Postal (CEP) brasileiro.

## Funcionalidades

- **Busca de CEP**: O usuário pode digitar um CEP e, através de uma API online, a aplicação retorna:
  - Endereço
  - Tipo de rua (rua, avenida, etc.)
  - Bairro
  - Cidade
  - Unidade Federativa (UF)

- **Interface Gráfica**: A aplicação possui uma interface gráfica amigável, criada com o WindowBuilder, que facilita a interação do usuário.

- **Tratamento de Erros**: A aplicação implementa tratamento de erros para garantir uma experiência de usuário suave e informativa em caso de problemas.

- **Validação de Campos**: Todos os campos de texto são validados para garantir que as entradas do usuário sejam corretas e completas.

## Tecnologias Utilizadas

- Java
- WindowBuilder (para criação da interface gráfica)
- API online para busca de CEP
- Bibliotecas:
  - [Atxy2k](https://github.com/atxy2k/Atxy2k) (para funcionalidades adicionais)
  - [dom4j](https://dom4j.github.io/) (para manipulação de XML)

## Como Usar

1. **Instalação**:
   - Clone este repositório ou baixe o projeto.
   - Abra o projeto no Eclipse IDE.

2. **Executando a Aplicação**:
   - Certifique-se de que as dependências necessárias estão instaladas.
   - Execute a classe principal da aplicação.

3. **Uso**:
   - Digite um CEP no campo apropriado.
   - Clique no botão para buscar o endereço.
   - As informações do endereço aparecerão nos campos designados
