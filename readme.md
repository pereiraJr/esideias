# ESIdeias

## VRaptor + Maven

### Importe o reposítório como porjeto Maven no Eclipse

No Eclipse vá em:
*File -> Import -> Existing Maven Project* 
Selecione a pasta descompactada do projeto e clique em *Finish*

### Baixe e configure o servidor no Eclipse

Faça o download do [Tomcat 8.0](http://ftp.unicamp.br/pub/apache/tomcat/tomcat-8/v8.0.43/bin/apache-tomcat-8.0.43.zip) no seu computador.
No Eclipse, vá na aba *Servers*, clique no link *...create new server*, na janela que abriu entre na pasta *Apache* e selecione *Tomcat8*.
Então clique em *next*, depois em *browse* e selecione a paste descompactada do *Tomcat* baixado. Para finalizar clique em *Finish*

### Adicone e inicie o projeto no servidor

Na aba *Servers* do Eclipse, clique no servidor que vc quer alocar o projeto com o botão direito e selecione *Add and Remove...*, apos isso selecione o projeto do no campo esquerdo e coloque-o no campo direiro. Clique em *Finish*.
Clique no servidor em que o projeto foi alocado com o botão direito e clique em *Start*. Após alguns segundos o servidor vai inicar e, se você não mudou nada das configurações do servidor, o site estará disponível no endereço *localhost:8080/ideas*.

## Docker + Docker-Compose

### Suba o container do banco:

Certifique-se que voê possui tanto a [Docke Enginer](https://docs.docker.com/engine/installation/) quanto o [Docker Compose](https://docs.docker.com/compose/install/) instalados em sua máquina.

```
$ docker -v 
$ docker-compose -v
```
Caso um dos dois não esteje instalado, instale-os seguindo as instruções dos links acima.

Agora é preciso definir algumas váriais de ambiente entes de subir o container. A forma mais indicada de se fazer isso é na raiz do projeto, no mesmo nível do arquivo  **docker-compose.yml**, criar um arquivo com o nome de  **.env** e definir essas váriaves da seguinte forma: 

```
##DataBase
POSTGRES_PASSWORD=<senha_para_db>
POSTGRES_USER=<user_para_db>
POSTGRES_DB=<nome_para_db>
```
Feito isso, ainda na pasta raiz, execute o comando
```
$ docker-compose up
```
**Obs:** Caso essa seja a primeira vez que você está fazendo esse passo-a-passo, esse processo pode levar vários minutos pois o docker precisa baixar as imagens externas *(postgres)*.

Você agora tem um container docker rodando com um postgres, já com um banco criado com as configurações que você definiu no arquivo .env, com  acessível em *localhost:5432*

  

  	

