# Micro-SaaS Host com Arquitetura Plugável (PF4J)

Este projeto demonstra uma arquitetura **Micro-SaaS** baseada em **módulos plugáveis**, desenvolvida em **Java 17, Spring Boot 3 e PF4J**.

## Estrutura
- **micro-saas-host** → Núcleo hospedeiro responsável por gerenciar plugins.
- **url-shortener-plugin** → Módulo de teste que implementa um encurtador de URLs.

## Execução
```bash
# Build do host
cd micro-saas-host
mvn clean package

# Build do plugin
cd ../url-shortener-plugin
mvn clean package

# Copiar o .jar para a pasta plugins
copy target/url-shortener-plugin-1.0.0.jar ../micro-saas-host/plugins/

# Rodar o host
cd ../micro-saas-host
java -jar target/micro-saas-host-1.0.0.jar


# Endpoint de teste
GET http://localhost:8080/url/shorten?originalUrl=https://google.com

Retorna : {
  "originalUrl": "https://google.com",
  "shortUrl": "https://short.ly/a7b9e5",
  "status": "success"
}
