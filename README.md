Classifica

Esempio di applicazione per creare una classifica di utenti ordinata per punteggio

Compilazione per Eclipse

<code>
mvn eclipse:eclipse
</code>

Per installare il data

Compilazione via linea di comando

<code>
mvn package
</code>

Creare il database postgres con nome utente classifica e password classifica

Per lanciare una volta compilato

<code>
java -jar target/classifica.jar &
</code>

L'applicazione crea automaticamente due utenti

l'utente admin con password admin per inserire altri utenti e gestire i punti
l'utente user con password user
