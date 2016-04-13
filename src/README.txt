Per executar primer em de crear un clau.
Un cop creada la clau compilem les clases.
Per executar primer executarem el SecureServer amb la comanda :
java -Djavax.net.ssl.keyStore=millave -Djavax.net.ssl.trustStore=millave -Djavax.net.ssl.keyStorePassword=dionis SecureServer
(millave ha de ser sustituit per el nom del teu fitxer de la clau i dionis per la contrasenya que tu posis)
Despres executarem la clase SecureClient.
java -Djavax.net.ssl.keyStore=millave -Djavax.net.ssl.trustStore=millave -Djavax.net.ssl.keyStorePassword=dionis SecureClient.
