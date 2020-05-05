# Build
mvn clean package && docker build -t com.mycompany/pw-favero .

# RUN

docker rm -f pw-favero || true && docker run -d -p 8080:8080 -p 4848:4848 --name pw-favero com.mycompany/pw-favero 