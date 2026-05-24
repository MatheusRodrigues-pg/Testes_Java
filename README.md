# Projeto de Automação com Java e Selenium

Este projeto contém testes automatizados usando Java e Selenium.

## Primeiros Passos

Estas instruções irão ajudá-lo a obter uma cópia do projeto e executá-la em sua máquina local para fins de desenvolvimento e teste.

### Pré-requisitos

* Java Development Kit (JDK) 8 ou superior
* Apache Maven
* Navegador Google Chrome (ou outros navegadores, se configurados nos testes)

### Clonando o Repositório

Para obter uma cópia do projeto, clone o repositório usando o git:

```bash
git clone https://github.com/MatheusRodrigues-pg/Testes_Java.git
cd Testes_Java
```
Substitua `https://github.com/MatheusRodrigues-pg/Testes_Java.git` pela URL real do seu repositório.

### Construindo o Projeto

Navegue até o diretório raiz do projeto e construa-o usando o Maven:

```bash
mvn clean install
```

Este comando compilará o código-fonte, executará os testes e empacotará a aplicação.

### Executando os Testes

Você pode executar todos os testes a partir da linha de comando usando o Maven:

```bash
mvn test
```

Se desejar executar testes específicos, você pode usar a opção `-Dtest`:

```bash
mvn test -Dtest=Front_AutomationExecTest
```

### Abrindo em uma IDE

Você pode importar este projeto para sua IDE favorita (por exemplo, IntelliJ IDEA, Eclipse, VS Code) como um projeto Maven.

* **IntelliJ IDEA**: Abrir -> Selecionar `pom.xml` -> Abrir como Projeto.

* **Eclipse**: Arquivo -> Importar -> Maven -> Projetos Maven Existentes -> Navegue até a raiz do projeto.

## Estrutura do Projeto

* `src/main/java`: Contém o código-fonte principal da aplicação (por exemplo, objetos de página, classes utilitárias).

* `src/test/java`: Contém as classes de teste.

* `pom.xml`: Arquivo de configuração do projeto Maven.

## Contribuições

Leia o arquivo [CONTRIBUTING.md](CONTRIBUTING.md) para obter detalhes sobre nosso código de conduta e o processo para enviar pull requests.

## Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE.md](LICENSE.md) para obter detalhes.
