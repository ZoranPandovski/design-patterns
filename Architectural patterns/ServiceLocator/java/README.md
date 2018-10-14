#Service Locator Pattern

Service - Actual Service which will process the request. Reference of such service is to be looked upon in JNDI server.

Context / Initial Context - JNDI Context carries the reference to service used for lookup purpose.

Service Locator - Service Locator is a single point of contact to get services by JNDI lookup caching the services.

Cache - Cache to store references of services to reuse them

Client - Client is the object that invokes the services via ServiceLocator.