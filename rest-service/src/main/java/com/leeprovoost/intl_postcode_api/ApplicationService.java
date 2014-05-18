package com.leeprovoost.intl_postcode_api;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.leeprovoost.intl_postcode_api.db.IntlPostcodeDao;
import com.leeprovoost.intl_postcode_api.health.IntlPostcodeHealthCheck;
import com.leeprovoost.intl_postcode_api.resources.IntlPostcodeResource;
import com.leeprovoost.intl_postcode_api.service.IntlPostcodeService;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.ScannerFactory;
import com.wordnik.swagger.config.SwaggerConfig;
import com.wordnik.swagger.jaxrs.config.DefaultJaxrsScanner;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import com.wordnik.swagger.jaxrs.reader.DefaultJaxrsApiReader;
import com.wordnik.swagger.reader.ClassReaders;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import com.yammer.dropwizard.config.FilterBuilder;

public class ApplicationService extends Service<ApplicationConfiguration> {

    public static void main(String[] args) throws Exception {
        new ApplicationService().run(args);
    }
   
	@Override
	public void initialize(Bootstrap<ApplicationConfiguration> bootstrap) {
		bootstrap.setName("intl-postcode-api");
		bootstrap.addBundle(new AssetsBundle("/swagger-ui"));
	}

	@Override
	public void run(ApplicationConfiguration configuration, Environment environment) throws Exception {

        DB mongoDB = null;
        // TODO handle database exceptions
        mongoDB = new MongoClient(
                configuration.getMongoHost(),
                configuration.getMongoPort()
        ).getDB(configuration.getMongoDb());

        final IntlPostcodeDao intlRoutingRepository = new IntlPostcodeDao(mongoDB);

        IntlPostcodeService inbtlRoutingService = new IntlPostcodeService(intlRoutingRepository);
        environment.addResource(new IntlPostcodeResource(inbtlRoutingService));
        
        // Swagger
        environment.addResource(new ApiListingResourceJSON());
        environment.addProvider(new ResourceListingProvider());
        environment.addProvider(new ApiDeclarationProvider());
        ScannerFactory.setScanner(new DefaultJaxrsScanner());
        ClassReaders.setReader(new DefaultJaxrsApiReader());
        SwaggerConfig config = ConfigFactory.config();
        config.setApiVersion("1.0.0");
        config.setBasePath("http://localhost:3000");
        
        // Healthchecks
        environment.addHealthCheck(new IntlPostcodeHealthCheck());
        
        // Support AJAX CORS
        FilterBuilder filterConfig = environment.addFilter(CrossOriginFilter.class, "/*");
        filterConfig.setInitParam(CrossOriginFilter.PREFLIGHT_MAX_AGE_PARAM, String.valueOf(60*60*24)); // 1 day - jetty-servlet CrossOriginFilter will convert to Int.
        filterConfig.setInitParam(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "http://localhost"); // comma separated list of allowed origin domains
        
	}

}
