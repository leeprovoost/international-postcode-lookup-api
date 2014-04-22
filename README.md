# DHL Routing Reference Data API

This is a Java Dropwizard API wrapper around DHL's publicly available [Routing Reference Data](http://www.dhl.co.uk/en/express/resource_centre/integrated_shipping_solutions/developer_download_centre1.html#reference_data).

This supports ESDv6 (latest version on 21 April 2014).

This is Alpha software quality and under heavy development.

## Get your REST service running

1. Make sure you have mongodb installed
2. Run the MongoDB database: `mongod`
3. Clone this git repository: `git clone git@github.com:leeprovoost/dhl-routing-reference-data-api.git`
4. Import the DHL data, follow instructions [here](https://github.com/leeprovoost/dhl-routing-reference-data-api/tree/master/routing_reference_data).
3. Go into the rest-service folder and build the service: `./build.sh`
4. Start the REST service: `./run.sh`

## Test the REST service directly

- View API listing: [http://localhost:3000/api-docs](http://localhost:3000/api-docs)
- View Swagger UI: [http://localhost:3000/swagger-ui/index.html](http://localhost:3000/swagger-ui/index.html)
- Get list of all countries: [http://localhost:3000/intl-routing-api/countries/](http://localhost:3000/intl-routing-api/countries/)
- Get list of cities (by default limited to 25): [http://localhost:3000/intl-routing-api/cities/](http://localhost:3000/intl-routing-api/cities/)
- View postcode lookup results: [http://localhost:3000/intl-routing-api/cities/?country=GB&postcode=SW8](http://localhost:3000/intl-routing-api/cities/?countryCode=GB&postcode=SW8)

![Swagger UI](https://github.com/leeprovoost/dhl-routing-reference-data-api/raw/master/screenshots/swagger.png)

## Use the experimental JQuery front-end

Note: Due to some loading issue that I am looking into, it's locked to UK postcode and city lookups right now.

1. Host the HTML page on your local Apache server
2. Open [http://localhost/frontend-jquery/index.html](http://localhost/frontend-jquery/index.html) (add the right port number)
3. Start typing in a UK postcode or a UK city

![JQuery front-end](https://github.com/leeprovoost/dhl-routing-reference-data-api/raw/master/screenshots/front-end.png)

## TODO

- Fix loading issue in JQuery code (front-end), currently locked to UK addresses
- Fix mongodb import code, force all fields to be string instead of mixed string and integer
- Create conversion scripts for the DHL data files
- Use proper Data Transfer Objects instead of passing on the model object and hide ugliness of mongodb objects
- Implement Exception handling
- Add tests
- Implement all business rules described in DHL book (validate postcode patterns)
- Investigate MongoDB indexes or use of ElasticSearch
