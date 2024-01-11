package engtelecom.bcd.lobinho;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
public class LobinhoApplication {

    public static void main(String[] args) {
        SpringApplication.run(LobinhoApplication.class, args);
    }
}
