package engtelecom.bcd.lobinho;

import engtelecom.bcd.lobinho.model.Alergia;
import engtelecom.bcd.lobinho.model.Jovem;
import engtelecom.bcd.lobinho.model.Responsavel;
import engtelecom.bcd.lobinho.model.TipoSanguineo;
import engtelecom.bcd.lobinho.model.distintivo.Distintivo;
import engtelecom.bcd.lobinho.model.distintivo.RequisitoDistintivo;
import engtelecom.bcd.lobinho.model.especialidade.AreaDoConhecimento;
import engtelecom.bcd.lobinho.model.especialidade.Especialidade;
import engtelecom.bcd.lobinho.model.especialidade.ProgressaoEspecialidade;
import engtelecom.bcd.lobinho.model.especialidade.RequisitoEspecialidade;
import engtelecom.bcd.lobinho.model.insignia.Insignia;
import engtelecom.bcd.lobinho.model.insignia.ProgressaoInsignia;
import engtelecom.bcd.lobinho.model.insignia.RequisitoInsignia;
import engtelecom.bcd.lobinho.repository.AlergiaRepository;
import engtelecom.bcd.lobinho.repository.JovemRepository;
import engtelecom.bcd.lobinho.repository.ResponsavelRepository;
import engtelecom.bcd.lobinho.repository.TipoSanguineoRepository;
import engtelecom.bcd.lobinho.repository.distintivo.DistintivoRepository;
import engtelecom.bcd.lobinho.repository.distintivo.ProgressaoDistintivoRepository;
import engtelecom.bcd.lobinho.repository.distintivo.RequisitoDistintivoRepository;
import engtelecom.bcd.lobinho.repository.especialidade.AreaDoConhecimentoRepository;
import engtelecom.bcd.lobinho.repository.especialidade.EspecialidadeRepository;
import engtelecom.bcd.lobinho.repository.especialidade.ProgressaoEspecialidadeRepository;
import engtelecom.bcd.lobinho.repository.especialidade.RequisitoEspecialidadeRepository;
import engtelecom.bcd.lobinho.repository.insignia.InsigniaRepository;
import engtelecom.bcd.lobinho.repository.insignia.ProgressaoInsigniaRepository;
import engtelecom.bcd.lobinho.repository.insignia.RequisitoInsigniaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class LobinhoRunner implements CommandLineRunner {

    @Autowired
    JovemRepository jovemRepository;

    @Autowired
    ResponsavelRepository responsavelRepository;

    @Autowired
    AlergiaRepository alergiaRepository;

    @Autowired
    TipoSanguineoRepository tipoSanguineoRepository;

    @Autowired
    DistintivoRepository distintivoRepository;

    @Autowired
    RequisitoDistintivoRepository requisitoDistintivoRepository;

    @Autowired
    ProgressaoDistintivoRepository progressaoDistintivoRepository;

    @Autowired
    AreaDoConhecimentoRepository areaDoConhecimentoRepository;

    @Autowired
    EspecialidadeRepository especialidadeRepository;

    @Autowired
    RequisitoEspecialidadeRepository requisitoEspecialidadeRepository;

    @Autowired
    ProgressaoEspecialidadeRepository progressaoEspecialidadeRepository;

    @Autowired
    InsigniaRepository insigniaRepository;

    @Autowired
    RequisitoInsigniaRepository requisitoInsigniaRepository;

    @Autowired
    ProgressaoInsigniaRepository progressaoInsigniaRepository;

    @Override
    public void run(String... args) throws Exception {
        try {

            log.info("Iniciando aplicação...");
            this.povoarBanco(); // Para gerar os dados foi usado o site: https://www.4devs.com.br/gerador_de_pessoas
            this.menu();

        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    private void menu() {
        Scanner input = new Scanner(System.in);
        int opcao = 0;
        while (true) {
            System.out.println("##-- Aplicação Escoteiros Ramo Lobinho --##");
            System.out.println("1 - Registrar dados");
            System.out.println("2 - Gerar relatório");
            System.out.print("> ");

            opcao = input.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("##-- Registrar dados --##");
                    System.out.println("1. Cadastrar jovem");
                    System.out.println("2. Alterar dados de um jovem");
                    System.out.println("3. Cadastrar requisito cumprido para um jovem");
                    System.out.print("> ");

                    opcao = input.nextInt();
                    input.nextLine();

                    switch (opcao) {
                        case 1:
                            System.out.println("##-- Cadastrar jovem --##");
                            cadastrarJovem(input);
                            break;
                        case 2:
                            System.out.println("##-- Alterar dados de jovem --##");
                            System.out.println("Funcionalidade ainda não disponível");
                            break;
                        case 3:
                            System.out.println("##-- Cadastrar requisito cumprido para um jovem");
                            System.out.println("1. Cadastrar requisito de especialidade cumprido");
                            System.out.println("2. Cadastrar requisito de insígnia cumprido");
                            System.out.println("3. Cadastrar requisito de distintivo cumprido");
                            System.out.print("> ");
                            opcao = input.nextInt();
                            input.nextLine();

                            switch (opcao) {
                                case 1:
                                    cadastrarRequisitoEspecialidadeCumprido(input);
                                    break;
                                case 2:
                                    System.out.println("Funcionalidade ainda não disponível");
                                    break;
                                case 3:
                                    System.out.println("Funcionalidade ainda não disponível");
                                    break;
                                default:
                                    System.out.println("Opção inválida. Selecione uma das opções acima.");
                                    break;
                            }
                            break;
                        default:
                            System.out.println("Opção inválida. Selecione uma das opções acima.");
                            break;
                    }
                    break;

                case 2:
                    System.out.println("##-- Gerar relatório --##");
                    System.out.println("1. Visualizar dados de um jovem");
                    System.out.println("2. Visualizar especialidades e insignias de um jovem");
                    System.out.println("3. Visualizar jovens que possuem uma determinada especialidade");
                    System.out.println("4. Visualizar requisitos já cumpridos por um determinado jovem para uma determinada especialidade");
                    System.out.println("5. Visualizar jovens que possuem todos requisitos para obter o Cruzeiro do Sul");
                    System.out.print("> ");

                    opcao = input.nextInt();
                    input.nextLine();

                    switch (opcao) {
                        case 1:
                            visualizarJovem(input);
                            break;
                        case 2:
                            visualizarEspecialidadeseInsigniasDeUmJovem(input);
                            break;
                        case 3:
                            visualizarJovensQuePossuemDeterminadaEspecialidade(input);
                            break;
                        case 4:
                            System.out.println("Funcionalidade ainda não disponível");
                            break;
                        case 5:
                            System.out.println("Funcionalidade ainda não disponível");
                            break;
                        default:
                            System.out.println("Opção inválida. Selecione uma das opções acima.");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida. Selecione uma das opções acima.");
            }
        }
    }

    private void povoarBanco() {

        log.info("Povoando banco...");
        System.out.println("Povoando o banco de dados, por favor aguarde...");

        this.criarAlergias();
        this.criarResponsaveis();
        this.criarTipoSanguineo();
        this.criarJovens();

        this.criarAreasDoConhecimento();
        this.criarEspecialidades();
        this.criarInsignias();
        this.criarDistintivos();

        this.criarRequisitosEspecialidades();
        this.criarRequisitosInsignias();
        this.criarRequisitosDistintivos();

        this.criarProgressaoEspecialidades();
        this.criarProgressaoInsignias();
        this.criarProgressaoDistintivos();

        log.info("Banco povoado com sucesso");

    }

    private void visualizarJovem(Scanner input) {

        Jovem j = null;
        while (j == null) {

            System.out.println("Qual o CPF do lobinho?");
            System.out.print("> ");
            String cpf = input.nextLine();

            Optional<Jovem> jovem = jovemRepository.findByCPF(cpf);

            if (jovem.isPresent()) {
                j = jovem.get();

                System.out.println("##########################");
                System.out.println("##-- Dados do Lobinho --##");
                System.out.println("##########################");
                System.out.println(j);

                System.out.println("Alergias:");
                if (!j.getAlergias().isEmpty()) {
                    for (Alergia a : j.getAlergias()) {
                        System.out.println("- " + a.getAlergia());
                    }
                } else {
                    System.out.println("- Nenhuma");
                }
                System.out.println("Responsáveis:");
                if (!j.getResponsaveis().isEmpty()) {
                    for (Responsavel r : j.getResponsaveis()) {
                        System.out.println("- " + r.getNome() + ", telefone: " + r.getTelefone() + ", e-mail: " + r.getEmail());
                    }
                }

                System.out.println("##########################");


            } else {
                System.out.println("Lobinho com CPF " + cpf + " não encontrado...");
            }
        }
    }

    private void visualizarEspecialidadeseInsigniasDeUmJovem(Scanner input) {

        Jovem j = null;
        while (j == null) {
            System.out.println("Qual o CPF do lobinho?");
            System.out.print("> ");
            String cpf = input.nextLine();

            Optional<Jovem> jovem = jovemRepository.findByCPF(cpf);

            if (jovem.isPresent()) {
                j = jovem.get();
                System.out.println("###############################");
                System.out.println(j.getNome());
                System.out.println("###############################");
                System.out.println("##--     Especialidades    --##");

                List<ProgressaoEspecialidade> progressao = progressaoEspecialidadeRepository.findAllByJovem(j);
                HashMap<Long, Integer> mapRequisitosPorEspecialidade = new HashMap<Long, Integer>();

                // Atualiza o hashmap com a quantidade de requisitos cumpridos por especialidade
                for (ProgressaoEspecialidade p : progressao) {
                    Long idEspecialidade = p.getRequisito().getEspecialidade().getIdEspecialidade();
                    if (mapRequisitosPorEspecialidade.containsKey(idEspecialidade)) {
                        mapRequisitosPorEspecialidade.put(idEspecialidade, mapRequisitosPorEspecialidade.get(idEspecialidade) + 1);
                    } else {
                        mapRequisitosPorEspecialidade.put(idEspecialidade, 1);
                    }
                }

                if (mapRequisitosPorEspecialidade.isEmpty()) {
                    System.out.println("Nenhum progresso");
                }

                // Imprime na tela o progresso do usuário em todas as especialidades, bem como seu nível e quantidade de requisitos cumpridos
                for (Map.Entry<Long, Integer> entry : mapRequisitosPorEspecialidade.entrySet()) {
                    Long idEspec = entry.getKey();
                    Integer requisitosCumpridos = entry.getValue();
                    Optional<Especialidade> esp = especialidadeRepository.findById(idEspec);
                    if (esp.isPresent()) {
                        Especialidade e = esp.get();
                        System.out.print(e.getNome() + " nível ");
                        float totalRequisitos = e.getRequisitos().size();
                        float razaoRequisitosCumpridos = requisitosCumpridos.floatValue() / totalRequisitos;
                        if (razaoRequisitosCumpridos == 1) {
                            System.out.print(3);
                        } else if (razaoRequisitosCumpridos >= (float) 2 / 3) {
                            System.out.print(2);
                        } else if (razaoRequisitosCumpridos >= (float) 1 / 3) {
                            System.out.print(1);
                        } else {
                            System.out.print(0);
                        }
                        System.out.println(" (" + requisitosCumpridos + "/" + (int) totalRequisitos + ")");
                    }
                }
                System.out.println("###############################");
                System.out.println("##--       Insignias       --##");

                List<ProgressaoInsignia> progressaoInsignias = progressaoInsigniaRepository.findAllByJovem(j);
                HashMap<Long, Integer> mapRequisitosPorInsignia = new HashMap<Long, Integer>();

                for (ProgressaoInsignia pi : progressaoInsignias) {
                    Long idInsignia = pi.getRequisito().getInsignia().getIdInsignia();
                    if (mapRequisitosPorInsignia.containsKey(idInsignia)) {
                        mapRequisitosPorInsignia.put(idInsignia, mapRequisitosPorInsignia.get(idInsignia) + 1);
                    } else {
                        mapRequisitosPorInsignia.put(idInsignia, 1);
                    }
                }

                if (mapRequisitosPorInsignia.isEmpty()) {
                    System.out.println("Nenhum progresso");
                }

                for (Map.Entry<Long, Integer> entry : mapRequisitosPorInsignia.entrySet()) {
                    Long idInsignia = entry.getKey();
                    Integer requisitosCumpridos = entry.getValue();
                    Optional<Insignia> ins = insigniaRepository.findById(idInsignia);
                    if(ins.isPresent()) {
                        Insignia i = ins.get();
                        int totalRequisitos = i.getRequisitos().size();
                        if (requisitosCumpridos == totalRequisitos) {
                            System.out.println(i.getNome() + " (obtida)");
                        } else {
                            System.out.println(i.getNome() + " (" + requisitosCumpridos + "/" + totalRequisitos + ")");
                        }
                    }
                }
                System.out.println("###############################");
            }
        }
    }

    private void visualizarJovensQuePossuemDeterminadaEspecialidade(Scanner input) {
        Iterable<Especialidade> especialidades = especialidadeRepository.findAll();
        HashMap<Integer, Especialidade> mapEspecialidades = new HashMap<Integer, Especialidade>();
        int i = 1;
        for (Especialidade esp : especialidades) {
            mapEspecialidades.put(i, esp);
            System.out.println(i + ". " + esp.getNome());
            i++;
        }
        int opcao;
        do {
            System.out.println("Selecione uma especialidade: ");
            System.out.print("> ");
            opcao = input.nextInt();
            input.nextLine();
        } while (opcao > mapEspecialidades.size());
        Especialidade especEscolhida = mapEspecialidades.get(opcao);
        List<RequisitoEspecialidade> requisitosEspecEscolhida = especEscolhida.getRequisitos();

        Iterable<Jovem> jovens = jovemRepository.findAll();
        System.out.println("Jovens que possuem a especialidade " + especEscolhida.getNome() + ":");
        for (Jovem j : jovens) {
            i = 0;
            for (ProgressaoEspecialidade p : j.getProgressaoEspecialidades()) {
                for (RequisitoEspecialidade r : requisitosEspecEscolhida) {
                    if (r.getIdRequisitoEspecialidade().equals(p.getRequisito().getIdRequisitoEspecialidade())) {
                        i++;
                    }
                }
            }
            float razao = (float) i /requisitosEspecEscolhida.size();
            if (razao == 1) {
                System.out.println(j.getNome() + " (CPF " + j.getCPF() + "): Nível: 3" );
            } else if (razao >= (float) 2 /3) {
                System.out.println(j.getNome() + " (CPF " + j.getCPF() + "): Nível: 2" );
            } else if (razao >= (float) 1 /3) {
                System.out.println(j.getNome() + " (CPF " + j.getCPF() + "): Nível: 1" );
            }
        }
    }

    private void cadastrarJovem(Scanner input) {

        System.out.println("Informe o nome do lobinho:");
        System.out.print("> ");
        String nome = input.nextLine();

        Date data = null;
        while (data == null) {
            System.out.println("Informe a data de nascimento (formato YYYY-MM-DD):");
            System.out.print("> ");
            String dataString = input.nextLine();
            data = criarDataPorString(dataString);
            if (data == null) {
                System.out.println("Data inserida inválida...");
            }
        }

        String cpf;
        Optional<Jovem> possivelJovem;
        do {
            System.out.println("Informe o CPF do lobinho (formato 123.456.789-10):");
            System.out.print("> ");
            cpf = input.nextLine();

            possivelJovem = jovemRepository.findByCPF(cpf);

            if (possivelJovem.isPresent()) {
                System.out.println("Já existe um jovem cadastrado com este CPF...");
            }

        } while (possivelJovem.isPresent());


        System.out.println("Informe o endereço:");
        System.out.print("> ");
        String endereco = input.nextLine();

        TipoSanguineo t = null;
        while (t == null) {
            System.out.println("Informe o tipo sanguíneo:");
            System.out.print("> ");
            String tipoString = input.nextLine();

            Optional<TipoSanguineo> tipoSanguineo = tipoSanguineoRepository.findByTipo(tipoString);
            if (tipoSanguineo.isPresent()) {
                t = tipoSanguineo.get();
            } else {
                System.out.println("Tipo sanguíneo " + tipoString + " inválido. Você deve escolher uma das opções:\n" +
                        "-> A+,A-,B+,B-,AB+,AB-,O+,O-");
            }
        }

        Set<Responsavel> responsaveisList = new HashSet<>();
        while (responsaveisList.isEmpty()) {
            System.out.println("Informe o CPF dos responsáveis separados por vírgula\n" +
                    "Exemplo: 491.979.710-90,864.292.258-36");
            System.out.print("> ");
            String cpfResponsaveis = input.nextLine();
            String[] arrayCPFs = cpfResponsaveis.split(",");

            Optional<Responsavel> responsavel;
            for (String arrayCPF : arrayCPFs) {
                responsavel = responsavelRepository.findByCPF(arrayCPF);
                if (responsavel.isPresent()) {
                    Responsavel r = responsavel.get();
                    responsaveisList.add(r);
                } else {
                    System.out.println("Responsável com CPF " + arrayCPF + " não encontrado...");
                }
            }
        }

        Set<Alergia> alergiasList = new HashSet<>();
        while (alergiasList.isEmpty()) {
            System.out.println("Informe as alergias que o jovem possui começando por letra maiúscula e separadas por vírgula\n" +
                    "Exemplo: Leite,Ovo");
            System.out.print("> ");
            String alergiaString = input.nextLine();

            if (alergiaString.isEmpty())
                break;

            String[] arrayAlergias = alergiaString.split(",");

            Optional<Alergia> alergia;
            for (String arrayAlergia : arrayAlergias) {
                alergia = alergiaRepository.findByAlergia(arrayAlergia);
                if (alergia.isPresent()) {
                    Alergia a = alergia.get();
                    alergiasList.add(a);
                } else {
                    System.out.println("Alergia com nome " + arrayAlergia + " não encontrada no banco...");
                }
            }
        }

        Jovem jovem = new Jovem(nome, data, cpf, endereco, t);

        for (Responsavel r : responsaveisList) {
            jovem.adicionarResponsavel(r);
        }

        for (Alergia a : alergiasList) {
            jovem.adicionarAlergia(a);
        }

        jovemRepository.save(jovem);
        System.out.println("Jovem cadastrado com sucesso!");

    }

    private void cadastrarRequisitoEspecialidadeCumprido(Scanner input) {
        Jovem j = null;
        while (j == null) {
            System.out.println("Qual o CPF do lobinho?");
            System.out.print("> ");
            String cpf = input.nextLine();

            Optional<Jovem> jovem = jovemRepository.findByCPF(cpf);

            if (jovem.isPresent()) {
                j = jovem.get();

                // Iterar todas as especialidades e mostrar na tela para o usuário escolher
                // Ler a entrada do teclado e obter do hashmap a especialidade escolhida pelo usuário
                // Iterar todos os requisitos da especialidade escolhida e mostrar na tela para o usuário escolher qual cadastrar
                // Ler a entrada do teclado e obter do hashmap o requisito escolhido pelo usuário
                // Cadastrar uma progressão

                Iterable<Especialidade> especialidades = especialidadeRepository.findAll();
                HashMap<Integer, Especialidade> mapEspecialidades = new HashMap<Integer, Especialidade>();
                int i = 1;
                for (Especialidade esp : especialidades) {
                    mapEspecialidades.put(i, esp);
                    System.out.println(i + ". " + esp.getNome());
                    i++;
                }

                int opcao;
                do {
                    System.out.println("Para qual especialidade deseja registrar uma progressão?");
                    System.out.print("> ");
                    opcao = input.nextInt();
                    input.nextLine();
                    if (opcao > mapEspecialidades.size() || opcao <= 0) {
                        System.out.println("Opção inválida...");
                    }
                } while (opcao > mapEspecialidades.size() || opcao <= 0);

                Especialidade especEscolhida = mapEspecialidades.get(opcao);

                Iterable<RequisitoEspecialidade> requisitos = requisitoEspecialidadeRepository.findByEspecialidade(especEscolhida);
                HashMap<Integer, RequisitoEspecialidade> mapRequisitos = new HashMap<Integer, RequisitoEspecialidade>();

                i = 1;
                for (RequisitoEspecialidade req : requisitos) {
                    mapRequisitos.put(i, req);
                    System.out.println(i + ". " + req.getDescricao());
                    i++;
                }

                // Loop que verifica se jovem já cumpriu o requisito
                Optional<ProgressaoEspecialidade> progressaoPresente;
                RequisitoEspecialidade reqEscolhido;
                do {
                    do {
                        System.out.println("Qual requisito deseja registrar como cumprido?");
                        System.out.print("> ");
                        opcao = input.nextInt();
                        input.nextLine();
                        if (opcao > mapRequisitos.size() || opcao <= 0) {
                            System.out.println("Opção inválida...");
                        }
                    } while (opcao > mapRequisitos.size() || opcao <= 0);
                    reqEscolhido = mapRequisitos.get(opcao);
                    progressaoPresente = progressaoEspecialidadeRepository.findByJovemAndRequisito(j, reqEscolhido);
                    if (progressaoPresente.isPresent()) {
                        System.out.println("Requisito já cumprido. Selecione outro...");
                    }
                } while (progressaoPresente.isPresent());

                Date data = null;
                while (data == null) {
                    System.out.println("Qual a data em que o lobinho cumpriu o requisito?");
                    System.out.print("> ");

                    String dataString = input.nextLine();
                    data = criarDataPorString(dataString);

                    if (data == null) {
                        System.out.println("Data inválida. Tente novamente...");
                    }
                }
                ProgressaoEspecialidade reqCumprido = new ProgressaoEspecialidade(data, reqEscolhido, j);
                progressaoEspecialidadeRepository.save(reqCumprido);
                System.out.println("Progressão registrada com sucesso!");
            } else {
                System.out.println("Lobinho não encontrado, tente novamente...");
            }
        }
    }

    private void criarResponsaveis() {

        log.info("Povoando tabela responsavel...");

        Responsavel nicolas = new Responsavel("Nicolas Severino da Cruz", "491.979.710-90", "(77) 2912-9691", "nicolas.dacruz@example.org");
        Responsavel raul = new Responsavel("Raul Julio Bruno Alves", "016.005.900-39", "(68) 99255-8601", "raul.alves@example.org");
        Responsavel osvaldo = new Responsavel("Osvaldo Kaique Hugo Rezende", "213.118.798-03", "(86) 99910-8836", "osvaldo.rezende@example.org");

        Responsavel beatriz = new Responsavel("Beatriz Hadassa Manuela Silveira", "828.107.861-86", "(82) 99576-6751", "beatriz.silveira@example.org");
        Responsavel luzia = new Responsavel("Luzia Alessandra Novaes", "864.292.258-36", "(84) 98490-4275", "luzia.novaes@example.org");
        Responsavel caroline = new Responsavel("Caroline Eduarda Benedita Farias", "150.579.862-01", "(42) 99309-1098", "caroline.farias@example.org");

        responsavelRepository.save(nicolas);
        responsavelRepository.save(raul);
        responsavelRepository.save(osvaldo);

        responsavelRepository.save(beatriz);
        responsavelRepository.save(luzia);
        responsavelRepository.save(caroline);

    }

    private void criarAlergias() {

        log.info("Povoando tabela alergia...");

        Alergia leite = new Alergia("Leite");
        Alergia ovo = new Alergia("Ovo");
        Alergia rinite = new Alergia("Rinite alérgica");
        Alergia aranha = new Alergia("Picada de aranha");

        alergiaRepository.save(leite);
        alergiaRepository.save(ovo);
        alergiaRepository.save(rinite);
        alergiaRepository.save(aranha);

    }

    private void criarTipoSanguineo() {

        log.info("Povoando tabela tipo_sanguineo...");

        TipoSanguineo Ap = new TipoSanguineo("A+");
        TipoSanguineo An = new TipoSanguineo("A-");
        TipoSanguineo Bp = new TipoSanguineo("B+");
        TipoSanguineo Bn = new TipoSanguineo("B-");
        TipoSanguineo ABp = new TipoSanguineo("AB+");
        TipoSanguineo ABn = new TipoSanguineo("AB-");
        TipoSanguineo Op = new TipoSanguineo("O+");
        TipoSanguineo On = new TipoSanguineo("O-");

        tipoSanguineoRepository.save(Ap);
        tipoSanguineoRepository.save(An);
        tipoSanguineoRepository.save(Bp);
        tipoSanguineoRepository.save(Bn);
        tipoSanguineoRepository.save(ABp);
        tipoSanguineoRepository.save(ABn);
        tipoSanguineoRepository.save(Op);
        tipoSanguineoRepository.save(On);

    }

    private void criarJovens() {

        log.info("Povoando tabela jovem...");

        TipoSanguineo Ap = tipoSanguineoRepository.findById(1L).orElseThrow();
        TipoSanguineo An = tipoSanguineoRepository.findById(2L).orElseThrow();
        TipoSanguineo Bp = tipoSanguineoRepository.findById(3L).orElseThrow();
        TipoSanguineo Bn = tipoSanguineoRepository.findById(4L).orElseThrow();
        TipoSanguineo ABp = tipoSanguineoRepository.findById(5L).orElseThrow();
        TipoSanguineo ABn = tipoSanguineoRepository.findById(6L).orElseThrow();
        TipoSanguineo Op = tipoSanguineoRepository.findById(7L).orElseThrow();
        TipoSanguineo On = tipoSanguineoRepository.findById(8L).orElseThrow();

        criarJovem("Bruno Kevin Jesus", "2015-07-15", "609.475.479-40", "Rua Raquel de Queiroz, 809", "AB+", "491.979.710-90,828.107.861-86", "leite");
        criarJovem("Arlindo Cruz", "2016-09-14", "111.222.333-44", "Rua dos Bobos, 0", "A+", "864.292.258-36", "ovo");
        criarJovem("Ada Lovelace", "2015-12-10", "123.456.789-10", "Church of St. Mary Magdalene, Hucknall", "B-", "150.579.862-01", "");
        criarJovem("Alan Turing", "2014-07-23", "321.456.987-11", "Sackville Park", "O-", "150.579.862-01", "");
    }

    private void criarJovem(String nome, String data, String cpf, String endereco, String tipo, String cpfResponsaveis, String alergias) {
        Optional<TipoSanguineo> tipoSanguineo = tipoSanguineoRepository.findByTipo(tipo);
        TipoSanguineo t;
        if (tipoSanguineo.isPresent()) {
            t = tipoSanguineo.get();

            Optional<Jovem> possivelJovem = jovemRepository.findByCPF(cpf);
            if (possivelJovem.isEmpty()) {
                Jovem jovem = new Jovem(nome, criarDataPorString(data), cpf, endereco, t);

                if (!cpfResponsaveis.isEmpty()) {
                    String[] arrayCPFs = cpfResponsaveis.split(",");

                    for (String cpfResponsavel : arrayCPFs) {
                        Optional<Responsavel> resp = responsavelRepository.findByCPF(cpfResponsavel);
                        if (resp.isPresent()) {
                            Responsavel r = resp.get();
                            jovem.adicionarResponsavel(r);
                        }
                    }

                    if (!alergias.isEmpty()) {

                        String[] arrayAlergias = alergias.split(",");

                        for (String alergia : arrayAlergias) {
                            Optional<Alergia> ale = alergiaRepository.findByAlergia(alergia);
                            if (ale.isPresent()) {
                                Alergia a = ale.get();
                                jovem.adicionarAlergia(a);
                            }
                        }
                    }

                    jovemRepository.save(jovem);

                } else {
                    log.warn("Tentou cadastrar jovem sem responsável");
                }
            } else {
                log.warn("Tentou cadastrar jovem com um CPF já existente no banco");
            }
        } else {
            log.warn("Tentou cadastrar jovem com um tipo sanguíneo inexistente");
        }
    }

    private void criarAreasDoConhecimento() {

        log.info("Povoando tabela area_do_conhecimento...");

        AreaDoConhecimento cienciaTecnologia = new AreaDoConhecimento("Ciência e Tecnologia");
        AreaDoConhecimento cultura = new AreaDoConhecimento("Cultura");
        AreaDoConhecimento desportos = new AreaDoConhecimento("Desportos");
        AreaDoConhecimento habilidadesEscoteiras = new AreaDoConhecimento("Habilidades Escoteiras");
        AreaDoConhecimento servicos = new AreaDoConhecimento("Serviços");

        areaDoConhecimentoRepository.save(cienciaTecnologia);
        areaDoConhecimentoRepository.save(cultura);
        areaDoConhecimentoRepository.save(desportos);
        areaDoConhecimentoRepository.save(habilidadesEscoteiras);
        areaDoConhecimentoRepository.save(servicos);

    }

    private void criarEspecialidades() {

        log.info("Povoando tabela especialidade...");

        AreaDoConhecimento cienciaTecnologia = areaDoConhecimentoRepository.findById(1L).orElseThrow();
        AreaDoConhecimento cultura = areaDoConhecimentoRepository.findById(2L).orElseThrow();
        AreaDoConhecimento desportos = areaDoConhecimentoRepository.findById(3L).orElseThrow();
        AreaDoConhecimento habilidadesEscoteiras = areaDoConhecimentoRepository.findById(4L).orElseThrow();
        AreaDoConhecimento servicos = areaDoConhecimentoRepository.findById(5L).orElseThrow();

        Especialidade criptografia = new Especialidade("Criptografia", cienciaTecnologia); // https://www.escoteiros.org.br/especialidades/criptografia/
        Especialidade comedia = new Especialidade("Comédia", cultura); // https://www.escoteiros.org.br/especialidades/comedia/
        Especialidade basquetebol = new Especialidade("Basquetebol", desportos); // https://www.escoteiros.org.br/especialidades/basquetebol/
        Especialidade culinaria = new Especialidade("Culinária", habilidadesEscoteiras); // https://www.escoteiros.org.br/especialidades/culinaria/
        Especialidade arteDigital = new Especialidade("Arte Digital", servicos); // https://www.escoteiros.org.br/especialidades/arte-digital/

        especialidadeRepository.save(criptografia);
        especialidadeRepository.save(comedia);
        especialidadeRepository.save(basquetebol);
        especialidadeRepository.save(culinaria);
        especialidadeRepository.save(arteDigital);

    }

    private void criarRequisitosEspecialidades() {

        log.info("Povoando tabela requisito_especialidade...");

        // Requisitos da especialidade Criptografia

        Especialidade criptografia = especialidadeRepository.findById(1L).orElseThrow();
        RequisitoEspecialidade r1 = new RequisitoEspecialidade("Entender o que é encriptação e decriptação e realizar uma apresentação sobre o assunto.", criptografia);
        RequisitoEspecialidade r2 = new RequisitoEspecialidade("Saber o que é criptografia e explicar o seu significado e sua utilidade.", criptografia);
        RequisitoEspecialidade r3 = new RequisitoEspecialidade("Conhecer e apresentar a história de Alan Turing e sua importância na história da criptografia.", criptografia);
        RequisitoEspecialidade r4 = new RequisitoEspecialidade("Conhecer e explicar o que foi a Cifra de César e qual a importância dela na história da criptografia.", criptografia);
        RequisitoEspecialidade r5 = new RequisitoEspecialidade("Conhecer a diferença entre Cifras e Códigos.", criptografia);
        RequisitoEspecialidade r6 = new RequisitoEspecialidade("Conhecer e explicar a importância da frequência das letras em uma mensagem criptografada e qual sua vantagem para conseguir descriptografá-la.", criptografia);
        RequisitoEspecialidade r7 = new RequisitoEspecialidade("Conhecer 3 tipos de cifras ou códigos incluindo a função totiente de Euler, quando foram criadas e para que são usadas.", criptografia);
        RequisitoEspecialidade r8 = new RequisitoEspecialidade("Criar e apresentar sua própria cifra e código explicando-a.", criptografia);
        RequisitoEspecialidade r9 = new RequisitoEspecialidade("Realizar 1 (um) texto com algum tipo de cifra e código falando sobre o escotismo com no mínimo quinze palavras.", criptografia);
        RequisitoEspecialidade r10 = new RequisitoEspecialidade("Conhecer e explicar o sigilo perfeito exemplificando-o.", criptografia);
        RequisitoEspecialidade r11 = new RequisitoEspecialidade("Conhecer e explicar o que é a configuração da chave e o que é o espaço da chave e o que é criptografia de chave pública.", criptografia);
        RequisitoEspecialidade r12 = new RequisitoEspecialidade("Explique a importância da criptografia no armazenamento de dados e informações para a segurança pessoal.", criptografia);

        requisitoEspecialidadeRepository.save(r1);
        requisitoEspecialidadeRepository.save(r2);
        requisitoEspecialidadeRepository.save(r3);
        requisitoEspecialidadeRepository.save(r4);
        requisitoEspecialidadeRepository.save(r5);
        requisitoEspecialidadeRepository.save(r6);
        requisitoEspecialidadeRepository.save(r7);
        requisitoEspecialidadeRepository.save(r8);
        requisitoEspecialidadeRepository.save(r9);
        requisitoEspecialidadeRepository.save(r10);
        requisitoEspecialidadeRepository.save(r11);
        requisitoEspecialidadeRepository.save(r12);

        // Requisitos da especialidade Comédia

        Especialidade comedia = especialidadeRepository.findById(2L).orElseThrow();
        r1 = new RequisitoEspecialidade("Relatar como surgiu a comédia e quais os seus principais gêneros.", comedia);
        r2 = new RequisitoEspecialidade("Contar pelo menos 5 (cinco) piadas a sua escolha sendo 3 (três) delas específicas da sua região, podendo as piadas estarem em 1 (um) mesmo roteiro (stand-up) ou não.", comedia);
        r3 = new RequisitoEspecialidade("Contar detalhes sobre seu filme, show ou livro de comédia predileto, relatando suas partes prediletas e como estão estruturadas as piadas.", comedia);
        r4 = new RequisitoEspecialidade("Contar qual a situação mais engraçada que você vivenciou, dramatizando de uma forma bem engraçada.", comedia);
        r5 = new RequisitoEspecialidade("Escrever 1 (um) esquete curta de comédia com sua matilha ou matilha/patrulha, e apresentar num fogo de conselho ou flor vermelha.", comedia);
        r6 = new RequisitoEspecialidade("Explicar como se estrutura uma piada, usando para isto 1 (um) roteiro/piada escrito por você ou apresentar (e executar) como funciona 1 (um) jogo de improviso na comédia.", comedia);
        r7 = new RequisitoEspecialidade("Criar uma paródia engraçada de uma música famosa e apresentar sozinho ou com sua matilha/patrulha ou matilha num fogo de conselho ou flor vermelha.", comedia);
        r8 = new RequisitoEspecialidade("Criar e contar uma piada relacionada ao escotismo.", comedia);
        r9 = new RequisitoEspecialidade("Fazer 1 (um) esquete engraçada sobre a história de Baden-Powell e do escotismo.", comedia);
        r10 = new RequisitoEspecialidade("Assistir a uma peça teatral de comédia e depois relatar a experiência.", comedia);
        r11 = new RequisitoEspecialidade("Produzir 1 (um) vídeo de comédia sozinho ou com os membros da sua matilha/patrulha, apresentando-o na internet.", comedia);
        r12 = new RequisitoEspecialidade("Escrever e apresentar 1 (um) show de comédia de no mínimo 5 (cinco) minutos.", comedia);

        requisitoEspecialidadeRepository.save(r1);
        requisitoEspecialidadeRepository.save(r2);
        requisitoEspecialidadeRepository.save(r3);
        requisitoEspecialidadeRepository.save(r4);
        requisitoEspecialidadeRepository.save(r5);
        requisitoEspecialidadeRepository.save(r6);
        requisitoEspecialidadeRepository.save(r7);
        requisitoEspecialidadeRepository.save(r8);
        requisitoEspecialidadeRepository.save(r9);
        requisitoEspecialidadeRepository.save(r10);
        requisitoEspecialidadeRepository.save(r11);
        requisitoEspecialidadeRepository.save(r12);

        // Requisitos da especialidade Basquetebol

        Especialidade basquetebol = especialidadeRepository.findById(3L).orElseThrow();

        r1 = new RequisitoEspecialidade("Apresentar a história do basquetebol brasileiro, citando seus principais títulos.", basquetebol);
        r2 = new RequisitoEspecialidade("Escrever uma breve biografia sobre 1 (um) jogador de basquetebol, que você considere relevante.", basquetebol);
        r3 = new RequisitoEspecialidade("Demonstrar as regras básicas do basquetebol, encenando, quando aplicável.", basquetebol);
        r4 = new RequisitoEspecialidade("Apresentar os principais esquemas táticos e a sua necessidade no desenvolvimento do jogo.", basquetebol);
        r5 = new RequisitoEspecialidade("Assistir uma partida de basquetebol, com o examinador, e explicar durante o jogo os nomes e funções das posições dos jogadores em quadra.", basquetebol);
        r6 = new RequisitoEspecialidade("Apontar os principais fundamentos técnicos usados, durante 1 (um) jogo.", basquetebol);
        r7 = new RequisitoEspecialidade("Assistir a 1 (um) jogo de basquetebol televisionado, fazendo anotações, e nos intervalos fazer 1 (um) retrospecto dos melhores lances e assistir a 1 (um) jogo em 1 (um) ginásio, apresentando 1 (um) relatório no término.", basquetebol);
        r8 = new RequisitoEspecialidade("Fazer uma visita a 1 (um) ginásio com quadra de basquetebol em 1 (um) dia que não haja jogo, e conhecer suas dependências.", basquetebol);
        r9 = new RequisitoEspecialidade("Explicar as regras de segurança ao assistir a uma partida de basquetebol em 1 (um) ginásio, o que deve ser feito para evitar confusões e tumultos, dando sua opinião sobre o que os torcedores devem fazer para promover a paz nos ginásios.", basquetebol);
        r10 = new RequisitoEspecialidade("Apresentar o sistema de pontuação de campeonatos regionais e nacionais regulamentados pela FIBA.", basquetebol);
        r11 = new RequisitoEspecialidade("Participar de uma competição de basquetebol, sendo capaz de reconhecer os principais gestos efetuados por 1 (um) árbitro.", basquetebol);
        r12 = new RequisitoEspecialidade("Organizar 1 (um) torneio de basquetebol, na modalidade de sua preferência, na sua seção ou com outros grupos escoteiros e convidados, com no mínimo 4 (quatro) times, utilizando 1 (um) dos sistemas de pontuação apresentados no item 11", basquetebol);

        requisitoEspecialidadeRepository.save(r1);
        requisitoEspecialidadeRepository.save(r2);
        requisitoEspecialidadeRepository.save(r3);
        requisitoEspecialidadeRepository.save(r4);
        requisitoEspecialidadeRepository.save(r5);
        requisitoEspecialidadeRepository.save(r6);
        requisitoEspecialidadeRepository.save(r7);
        requisitoEspecialidadeRepository.save(r8);
        requisitoEspecialidadeRepository.save(r9);
        requisitoEspecialidadeRepository.save(r10);
        requisitoEspecialidadeRepository.save(r11);
        requisitoEspecialidadeRepository.save(r12);

        // Requisitos da especialidade Culinária

        Especialidade culinaria = especialidadeRepository.findById(4L).orElseThrow();

        r1 = new RequisitoEspecialidade("Abrir latas de conserva, cortar legumes e preparar uma bebida.", culinaria);
        r2 = new RequisitoEspecialidade("Identificar os utensílios necessários para a preparação de uma refeição definida pelo examinador.", culinaria);
        r3 = new RequisitoEspecialidade("Fritar ovos e preparar saladas, decorando os pratos, e preparar uma bebida quente.", culinaria);
        r4 = new RequisitoEspecialidade("Fazer uma lista dos mantimentos com quantidades necessárias para uma refeição festiva para a seção.", culinaria);
        r5 = new RequisitoEspecialidade("Explicar como conservar os alimentos conforme a temperatura ambiente.", culinaria);
        r6 = new RequisitoEspecialidade("Preparar 1 (um) cardápio equilibrado para 1 (um) acampamento de final de semana, calculando as quantidades dos gêneros para a matilha/patrulha.", culinaria);
        r7 = new RequisitoEspecialidade("Cozinhar para a matilha/patrulha durante 1 (um) acampamento de final de semana, a lenha e a gás, demonstrando cuidados com a segurança e a higiene.", culinaria);
        r8 = new RequisitoEspecialidade("Preparar alguma iguaria da cozinha mateira, como pão de caçador, ovo na laranja, ovo no espeto, carne moída no espeto, etc.", culinaria);
        r9 = new RequisitoEspecialidade("Projetar e participar da montagem da cozinha do canto da matilha/patrulha em 1 (um) acampamento, justificando os cuidados adotados para reduzir os riscos de incêndio.", culinaria);
        r10 = new RequisitoEspecialidade("Preparar, em 1 (um) acampamento, 3 (três) tipos de sobremesa.", culinaria);
        r11 = new RequisitoEspecialidade("Limpar e preparar uma peça de carne e 1 (um) peixe.", culinaria);
        r12 = new RequisitoEspecialidade("Construir uma intendência no canto de matilha/patrulha, durante 1 (um) acampamento.", culinaria);

        requisitoEspecialidadeRepository.save(r1);
        requisitoEspecialidadeRepository.save(r2);
        requisitoEspecialidadeRepository.save(r3);
        requisitoEspecialidadeRepository.save(r4);
        requisitoEspecialidadeRepository.save(r5);
        requisitoEspecialidadeRepository.save(r6);
        requisitoEspecialidadeRepository.save(r7);
        requisitoEspecialidadeRepository.save(r8);
        requisitoEspecialidadeRepository.save(r9);
        requisitoEspecialidadeRepository.save(r10);
        requisitoEspecialidadeRepository.save(r11);
        requisitoEspecialidadeRepository.save(r12);

        // Requisitos da especialidade Arte Digital

        Especialidade arteDigital = especialidadeRepository.findById(5L).orElseThrow();

        r1 = new RequisitoEspecialidade("Apresentar à sua seção 1 (um) programa de desenho digital a sua escolha, demonstrando o uso de diversas ferramentas disponíveis, como texturas e filtros de cor.", arteDigital);
        r2 = new RequisitoEspecialidade("Explicar a importância do trabalho com layers, demonstrando a formatação de uma imagem utilizando esta ferramenta.", arteDigital);
        r3 = new RequisitoEspecialidade("Organizar uma exposição em sua seção, contendo pelo menos 5 (cinco) de seus trabalhos.", arteDigital);
        r4 = new RequisitoEspecialidade("Explicar ou à seção a importância dos efeitos de luz e sombra e quais as melhores técnicas para se conseguir os resultados desejados.", arteDigital);
        r5 = new RequisitoEspecialidade("Explicar o que é e como funciona uma mesa digitalizadora, demonstrando seu uso à seção.", arteDigital);
        r6 = new RequisitoEspecialidade("Fazer uma apresentação à matilha ou matilha/patrulha sobre a importância da paleta de cores selecionada para 1 (um) trabalho, utilizando recursos midiáticos de escolha livre (vídeos, apresentações de slides, cartazes.)", arteDigital);

        requisitoEspecialidadeRepository.save(r1);
        requisitoEspecialidadeRepository.save(r2);
        requisitoEspecialidadeRepository.save(r3);
        requisitoEspecialidadeRepository.save(r4);
        requisitoEspecialidadeRepository.save(r5);
        requisitoEspecialidadeRepository.save(r6);
    }

    private void criarProgressaoEspecialidades() {

        log.info("Povoando tabela progressao_especialidade...");

        Optional<Jovem> jovem = jovemRepository.findById(1L);

        if (jovem.isPresent()) {
            Jovem bruno = jovem.get();

            // Progressao na especialidade Criptografia
            Especialidade criptografia = especialidadeRepository.findById(1L).orElseThrow();
            List<RequisitoEspecialidade> requisitosEspecialidade = criptografia.getRequisitos();
            int dia = 5;
            ProgressaoEspecialidade progressaoEspecialidade;
            for (RequisitoEspecialidade req : requisitosEspecialidade) {
                progressaoEspecialidade = new ProgressaoEspecialidade(criarData(2015, 7, dia++), req, bruno);
                progressaoEspecialidadeRepository.save(progressaoEspecialidade);
            }

            // Progressao na especialidade Comédia
            Especialidade comedia = especialidadeRepository.findById(2L).orElseThrow();
            requisitosEspecialidade = comedia.getRequisitos();
            dia = 3;
            for (RequisitoEspecialidade req : requisitosEspecialidade) {
                progressaoEspecialidade = new ProgressaoEspecialidade(criarData(2015, 6, dia++), req, bruno);
                progressaoEspecialidadeRepository.save(progressaoEspecialidade);
            }

            Especialidade basquete = especialidadeRepository.findById(3L).orElseThrow();
            requisitosEspecialidade = basquete.getRequisitos();
            dia = 7;
            for (RequisitoEspecialidade req : requisitosEspecialidade) {
                progressaoEspecialidade = new ProgressaoEspecialidade(criarData(2015, 8, dia++), req, bruno);
                progressaoEspecialidadeRepository.save(progressaoEspecialidade);
            }

            Especialidade culinaria = especialidadeRepository.findById(4L).orElseThrow();
            requisitosEspecialidade = culinaria.getRequisitos();
            dia = 10;
            for (RequisitoEspecialidade req : requisitosEspecialidade) {
                progressaoEspecialidade = new ProgressaoEspecialidade(criarData(2015, 9, dia++), req, bruno);
                progressaoEspecialidadeRepository.save(progressaoEspecialidade);
            }

            Especialidade arteDigital = especialidadeRepository.findById(5L).orElseThrow();
            requisitosEspecialidade = arteDigital.getRequisitos();
            dia = 10;
            for (RequisitoEspecialidade req : requisitosEspecialidade) {
                progressaoEspecialidade = new ProgressaoEspecialidade(criarData(2015, 10, dia++), req, bruno);
                progressaoEspecialidadeRepository.save(progressaoEspecialidade);
            }
        }
    }

    private void criarInsignias() {

        log.info("Povoando tabela insignia...");

        Insignia aprender = new Insignia("Insígnia do Aprender");
        Insignia coneSul = new Insignia("Insígnia do Cone Sul");
        Insignia boaAcao = new Insignia("Insígnia da Boa Ação");
        Insignia lusofonia = new Insignia("Insígnia da Lusofonia");

        insigniaRepository.save(aprender);
        insigniaRepository.save(coneSul);
        insigniaRepository.save(boaAcao);
        insigniaRepository.save(lusofonia);
    }

    private void criarRequisitosInsignias() {

        log.info("Povoando tabela requisito_insignia...");

        // Requisitos insignia do aprender

        Insignia aprender = insigniaRepository.findById(1L).orElseThrow();

        RequisitoInsignia r1 = new RequisitoInsignia("Organizar o espaço de estudo adequadamente, observando a sua iluminação, local para acondicionamento dos materiais e ambiente.", aprender);
        RequisitoInsignia r2 = new RequisitoInsignia("Ter o seu material escolar devidamente organizado, demonstrado cuidados com os livros, cadernos e demais materiais.", aprender);
        RequisitoInsignia r3 = new RequisitoInsignia("Destinar o tempo adequado para seu estudo e tarefas de casa, relatando aos pais, a Akela ou outro Velho Lobo quanto tempo utiliza para essas atividades.", aprender);
        RequisitoInsignia r4 = new RequisitoInsignia("Participar, como Lobinho, de pelo menos uma edição do Projeto Educação Escoteira com sua Alcateia, ou de outra atividade em conjunto com escolas realizada pela sua Alcateia ou pelo seu Grupo Escoteiro/Seção Autônoma.", aprender);
        RequisitoInsignia r5 = new RequisitoInsignia("Participar ativamente de pelo menos duas atividades especiais em sua escola (Ex.: Festa Junina, Feira de Ciências, Excursão, etc.) e mostrar fotos ou relatório para a Alcateia.", aprender);
        RequisitoInsignia r6 = new RequisitoInsignia("Apoiar um colega de classe em alguma tarefa ou ajudá-lo a aprender algum conteúdo que tenha dificuldade.", aprender);
        RequisitoInsignia r7 = new RequisitoInsignia("Conversar com seus pais , Akela ou outro Velho Lobo sobre sua participação na escola, seu interesse pelos estudos e sobre os pontos que podem ser melhorados para ser um melhor aluno.", aprender);

        requisitoInsigniaRepository.save(r1);
        requisitoInsigniaRepository.save(r2);
        requisitoInsigniaRepository.save(r3);
        requisitoInsigniaRepository.save(r4);
        requisitoInsigniaRepository.save(r5);
        requisitoInsigniaRepository.save(r6);
        requisitoInsigniaRepository.save(r7);

        // Requisitos insignia do Cone Sul

        Insignia coneSul = insigniaRepository.findById(2L).orElseThrow();

        r1 = new RequisitoInsignia("Indicar, no mapa mundi, onde estão localizados os demais países do Cone Sul, sabendo reconhecer suas bandeiras e explicar o significado das cores de cada uma delas.", coneSul);
        r2 = new RequisitoInsignia("Pesquisar a história de algo importante por sua utilidade que tenha sido inventado em um dos países do Cone Sul.", coneSul);
        r3 = new RequisitoInsignia("Degustar pelo menos um prato típico de outro país do Cone Sul, conhecendo sua história e origem.", coneSul);
        r4 = new RequisitoInsignia("Visitar exposições ou feiras culturais referentes a outros países do Cone Sul.", coneSul);
        r5 = new RequisitoInsignia("Conhecer uma lenda ou conto de outro país do Cone Sul e contá-la para Alcateia.", coneSul);
        r6 = new RequisitoInsignia("Conhecer a principal dança típica de pelo menos dois países do Cone Sul.", coneSul);
        r7 = new RequisitoInsignia("Ir a uma peça de teatro cujo roteiro seja de outro país do Cone Sul e não esteja adaptado.", coneSul);
        RequisitoInsignia r8 = new RequisitoInsignia("Assistir uma animação ou filme nacional de outro país do Cone Sul.", coneSul);
        RequisitoInsignia r9 = new RequisitoInsignia("Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país do Cone Sul.", coneSul);
        RequisitoInsignia r10 = new RequisitoInsignia("Entrevistar alguém que esteja morando, ou tenha morado em algum país do Cone Sul.", coneSul);
        RequisitoInsignia r11 = new RequisitoInsignia("Descobrir quais distintivos poderia conquistar se fosse de outro país do Cone Sul.", coneSul);
        RequisitoInsignia r12 = new RequisitoInsignia("Ensinar a Alcateia a cantar uma canção escoteira de outro país do Cone Sul.", coneSul);
        RequisitoInsignia r13 = new RequisitoInsignia("Conhecer as principais terminologias do Ramo Lobinho (Alcateia, Matilha, acampamento, etc) em castelhano ou em outro idioma falado em países do Cone Sul, como o guarani.", coneSul);
        RequisitoInsignia r14 = new RequisitoInsignia("Conhecer os nomes e os símbolos das Associações Escoteiras dos países que integram o Cone Sul.", coneSul);

        requisitoInsigniaRepository.save(r1);
        requisitoInsigniaRepository.save(r2);
        requisitoInsigniaRepository.save(r3);
        requisitoInsigniaRepository.save(r4);
        requisitoInsigniaRepository.save(r5);
        requisitoInsigniaRepository.save(r6);
        requisitoInsigniaRepository.save(r7);
        requisitoInsigniaRepository.save(r8);
        requisitoInsigniaRepository.save(r9);
        requisitoInsigniaRepository.save(r10);
        requisitoInsigniaRepository.save(r11);
        requisitoInsigniaRepository.save(r12);
        requisitoInsigniaRepository.save(r13);
        requisitoInsigniaRepository.save(r14);

        // Requisitos da insígnia da boa ação

        Insignia boaAcao = insigniaRepository.findById(3L).orElseThrow();

        r1 = new RequisitoInsignia("Conhecer os principais problemas sociais de sua rua ou bairro e conversar com seus pais ou velhos lobos sobre como você poderia contribuir para resolvê-los.", boaAcao);
        r2 = new RequisitoInsignia("Conhecer instituições de sua comunidade que realizam ações assistenciais a pessoas necessitadas ou orientação para a melhoria da vida das pessoas, procurando saber de que forma sua Alcateia poderia ajudá-las.", boaAcao);
        r3 = new RequisitoInsignia("Participar de pelo menos uma edição do Mutirão Nacional Escoteiro de Ação Comunitária com sua Alcateia ou de outra atividade de ação comunitária realizada pela sua Alcateia ou por seu Grupo Escoteiro.", boaAcao);
        r4 = new RequisitoInsignia("Perceber os eventuais perigos a que estão expostos os lobinhos em uma excursão ou acampamento/acantonamento e ajudar a aplicar as regras de segurança para evitá-los.", boaAcao);
        r5 = new RequisitoInsignia("Participar de pelo menos três boas ações coletivas com sua Alcateia, contribuindo com ideias e ações para o planejamento e execução das atividades.", boaAcao);
        r6 = new RequisitoInsignia("Participar de uma ação comunitária promovida por alguma instituição de sua comunidade: igreja, clube, escola, posto de saúde, polícia, bombeiros, casa comercial, etc. e fazer um relatório sobre essa participação.", boaAcao);
        r7 = new RequisitoInsignia("Planejar e executar uma boa ação, diferente das realizadas anteriormente, que seja útil em sua Alcateia, casa, escola ou comunidade, com duração mínima de um mês, apresentando posteriormente os resultados para sua Alcateia.", boaAcao);

        requisitoInsigniaRepository.save(r1);
        requisitoInsigniaRepository.save(r2);
        requisitoInsigniaRepository.save(r3);
        requisitoInsigniaRepository.save(r4);
        requisitoInsigniaRepository.save(r5);
        requisitoInsigniaRepository.save(r6);
        requisitoInsigniaRepository.save(r7);

        // Requisitos da insígnia da lusofonia

        Insignia lusofonia = insigniaRepository.findById(4L).orElseThrow();

        r1 = new RequisitoInsignia("Pesquisar os temperos e especiarias típicos dos países lusófonos, também presentes no Brasil.", lusofonia);
        r2 = new RequisitoInsignia("Pesquisar a fauna e flora típicos dos países lusófonos, também presentes no Brasil.", lusofonia);
        r3 = new RequisitoInsignia("Pesquisar utensílios e invenções utilizadas no Brasil, criados em algum país lusófonos.", lusofonia);
        r4 = new RequisitoInsignia("Indicar, no mapa mundi, onde estão localizados os países lusófonos e reconhecer suas respectivas bandeiras.", lusofonia);
        r5 = new RequisitoInsignia("Visitar exposições ou feiras culturais referentes a outros países lusófonos.", lusofonia);
        r6 = new RequisitoInsignia("Degustar pelo menos uma refeição típica de outro país lusófono, conhecendo sua história e origem.", lusofonia);
        r7 = new RequisitoInsignia("Ir a uma peça de teatro cujo roteiro seja de outro país lusófono e não esteja adaptado.", lusofonia);
        r8 = new RequisitoInsignia("Assistir um espetáculo (circo, show musical etc) que seja originário de outro país lusófono.", lusofonia);
        r9 = new RequisitoInsignia("Conhecer uma lenda ou conto de um outro país lusófono, e contá-la para sua Alcateia.", lusofonia);
        r10 = new RequisitoInsignia("Entrevistar alguém que tenha morado, ou esteja morando, em um país lusófono;", lusofonia);
        r11 = new RequisitoInsignia("Ver um filme nacional ou animação de outro país Lusófono;", lusofonia);
        r12 = new RequisitoInsignia("Enviar e receber uma correspondência, ou e-mail, contendo uma foto de sua Alcateia, para um lobinho de outro país Lusófono", lusofonia);
        r13 = new RequisitoInsignia("Descobrir quais distintivos o Lobinho poderia conquistar se fosse de outro país lusófono.", lusofonia);
        r14 = new RequisitoInsignia("Fazer uma lista de termos escoteiros utilizados em outro país lusófono.", lusofonia);
        RequisitoInsignia r15 = new RequisitoInsignia("Conhecer o símbolo das Associações Escoteiras dos países lusófonos.", lusofonia);

        requisitoInsigniaRepository.save(r1);
        requisitoInsigniaRepository.save(r2);
        requisitoInsigniaRepository.save(r3);
        requisitoInsigniaRepository.save(r4);
        requisitoInsigniaRepository.save(r5);
        requisitoInsigniaRepository.save(r6);
        requisitoInsigniaRepository.save(r7);
        requisitoInsigniaRepository.save(r8);
        requisitoInsigniaRepository.save(r9);
        requisitoInsigniaRepository.save(r10);
        requisitoInsigniaRepository.save(r11);
        requisitoInsigniaRepository.save(r12);
        requisitoInsigniaRepository.save(r13);
        requisitoInsigniaRepository.save(r14);
        requisitoInsigniaRepository.save(r15);

    }

    private void criarProgressaoInsignias() {

        log.info("Povoando tabela progressao_insignia...");

        Optional<Jovem> jovem = jovemRepository.findById(1L);

        if (jovem.isPresent()) {
            Jovem bruno = jovem.get();

            Insignia aprender = insigniaRepository.findById(1L).orElseThrow();
            List<RequisitoInsignia> requisitoInsignias = aprender.getRequisitos();
            int dia = 5;
            ProgressaoInsignia progressaoInsignia;
            for (RequisitoInsignia req : requisitoInsignias) {
                progressaoInsignia = new ProgressaoInsignia(criarData(2015, 7, dia++), req, bruno);
                progressaoInsigniaRepository.save(progressaoInsignia);
            }
        }

    }

    private void criarDistintivos() {

        log.info("Povoando tabela distintivo...");

        Distintivo pataTenra = new Distintivo("Lobo Pata Tenra");
        Distintivo saltador = new Distintivo("Lobo Saltador");
        Distintivo rastreador = new Distintivo("Lobo Rastreador");
        Distintivo cacador = new Distintivo("Lobo Caçador");
        Distintivo cruzeiroDoSul = new Distintivo("Cruzeiro do Sul");

        distintivoRepository.save(pataTenra);
        distintivoRepository.save(saltador);
        distintivoRepository.save(rastreador);
        distintivoRepository.save(cacador);
        distintivoRepository.save(cruzeiroDoSul);

    }

    private void criarRequisitosDistintivos() {

        log.info("Povoando tabela requisito_distintivo...");

        // Caminho do Integrar - Lobo Pata Tenra
        Distintivo distintivo = distintivoRepository.findById(1L).orElseThrow();
        RequisitoDistintivo requisito = new RequisitoDistintivo("Completar o Caminho do Integrar", distintivo);
        requisitoDistintivoRepository.save(requisito);

        // Caminho do Descobrir - Lobo Saltador
        distintivo = distintivoRepository.findById(2L).orElseThrow();
        requisito = new RequisitoDistintivo("Para conquistar o distintivo de Lobo Saltador, você precisa fazer pelo menos a metade das atividades propostas no seu guia/aplicativo.", distintivo);
        requisitoDistintivoRepository.save(requisito);

        // Caminho do Rastrear - Lobo Rastreador
        distintivo = distintivoRepository.findById(3L).orElseThrow();
        requisito = new RequisitoDistintivo("Para conquistar o distintivo de Lobo Rastreador, você precisa fazer as atividades que restam, e assim cumprir 100% das atividades.", distintivo);
        requisitoDistintivoRepository.save(requisito);

        // Caminho do Caçar - Lobo Caçador
        distintivo = distintivoRepository.findById(4L).orElseThrow();
        requisito = new RequisitoDistintivo("Para conquistar o distintivo de Lobo Caçador, você deve realizar a metade das atividades deste bloco.", distintivo);
        requisitoDistintivoRepository.save(requisito);

        // Caminho das Estrelas - Cruzeiro do Sul
        distintivo = distintivoRepository.findById(5L).orElseThrow();
        requisito = new RequisitoDistintivo("Estrela ALFA: Você deve cumprir o restante das atividades deste bloco", distintivo);
        requisitoDistintivoRepository.save(requisito);
        requisito = new RequisitoDistintivo("Estrela BETA: Participar de três acampamentos ou acantonamentos com a sua Alcateia;", distintivo);
        requisitoDistintivoRepository.save(requisito);
        requisito = new RequisitoDistintivo("Estrela DELTA: Conquistar 5 especialidades de 3 áreas do conhecimento diferentes", distintivo);
        requisitoDistintivoRepository.save(requisito);
        requisito = new RequisitoDistintivo("Estrela GAMA: Conquistar uma das sete Insígnias de Interesse Especial do Ramo Lobinho", distintivo);
        requisitoDistintivoRepository.save(requisito);
        requisito = new RequisitoDistintivo("Estrela EPSILON: Ser recomendado pelos Velhos Lobos e pela Roca de Conselho por ser um Lobinho dedicado, frequente às atividades da Alcateia e cumpridor da Lei e Promessa do Lobinho.", distintivo);
        requisitoDistintivoRepository.save(requisito);
    }

    private void criarProgressaoDistintivos() {

        log.info("Povoando tabela progresso_distintivo...");

    }

    private Date criarData(int ano, int mes, int dia) {
        return new Date(ano - 1900, mes - 1, dia);
    }

    private Date criarDataPorString(String data) {
        try {
            return Date.valueOf(data);
        } catch (Exception e) {
            return null;
        }
    }
}
