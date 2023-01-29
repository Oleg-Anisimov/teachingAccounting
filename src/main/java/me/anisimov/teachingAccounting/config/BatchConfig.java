package me.anisimov.teachingAccounting.config;

import me.anisimov.teachingAccounting.SpringBatch.Animal;
import me.anisimov.teachingAccounting.SpringBatch.AnimalFieldSetMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@EnableBatchProcessing
@Configuration
public class BatchConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    private static final String[] TOKENS = {"id", "name"};

    @Bean
    public Job job(Step step) {
        return jobBuilderFactory.get("job")
                .flow(step)
                .end()
                .build();
    }

    @Bean
    public Step step (ItemReader<Animal> csvItemReader, ItemWriter<Animal> jsonItemWriter){
        return stepBuilderFactory
                .get("step1")
                .<Animal,Animal> chunk(3)
                .reader(csvItemReader)
                .processor(animalWriterProcessor)
                .writer(jsonItemWriter)
                .build();
    }

    @Bean
    @StepScope
    public FlatFileItemReader<Animal> csvItemReader (@Value("#{jobParameters['file.input']}") String input) {
        FlatFileItemReaderBuilder<Animal> builder = new FlatFileItemReaderBuilder<>();
        FieldSetMapper<Animal> animalFieldSetMapper = new AnimalFieldSetMapper();
        return builder
                .name("Reader")
                .resource(new FileSystemResource(input))
                .delimited()
                .names(TOKENS)
                .fieldSetMapper(animalFieldSetMapper)
                .build();
    }

    @Bean
    @StepScope
    public JsonFileItemWriter<Animal> jsonItemWriter
}
