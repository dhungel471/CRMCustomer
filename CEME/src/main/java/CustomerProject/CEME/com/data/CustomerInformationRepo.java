package CustomerProject.CEME.com.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import CustomerProject.CEME.com.model.CustomerInformation;

public interface CustomerInformationRepo extends MongoRepository<CustomerInformation, String> {
    public List<CustomerInformation> findByLastName(String lastName);
}