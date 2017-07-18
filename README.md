# Overview
This is a Java 8 project using standard maven directory layout, using maven as dependency manager.

It accepts as input a list of comma separated accession numbers with the following format: **L...LN...N** (e.g. _AB1234_), where **L...L** denotes one or more _ASCII7_ letters and **N** denotes one or more digits (0,1,2,3,4,5,6,7,8 or 9).

This software returns a list of accession numbers where any consecutive digits, **N...N**, that share the same prefix, **L...L**, are collapsed into an accession number range.

An accession number range has the following format : **L...LN...N-L...LN...N** (e.g. _A00001-A00005_).

Please note that the **N...N** digits are left padded using _0s_ (e.g. _00001_) and that the length of the **N...N** digits must be the same for accession numbers to be part of the same accession number range.

**Example input:**
_A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116,ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1_

**Expected output:**
_A00000,A0001,ABCDEFG1,DRR2110012,ERR000111-ERR000113,ERR000115-ERR000116,ERR100114,ERR200000001-ERR200000003,SRR211001_

**NOTE** there are no trailing spaces after each ',' in the _example input_ nor in the _expected output_.

# Using the software
Clone the repository using its URL you can copy and paste as shown in the follwing command

```vim
git clone git@github.com:mbdebian/accession-service.git
```

Once cloned, you can use **Maven** for running the unit test as follows (in the root folder of the repository)
```vim
mvn clean test
```

Compile the software using the following **Maven** command
```vim
mvn clean package
```

This will create a _.jar_ file in a folder called **target**, like the following

> accession-service-0.0.1-SNAPSHOT.jar

## Running as command line tool
To run this software as a command line tool, i.e. no web interface, just provide the list of accessions as a parameter, like in the following example (after compiling the software, and running from the repository root folder):

```vim
java -jar target/accession-service-0.0.1-SNAPSHOT.jar A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116,ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1
```

The sorted and collapsed list of accession will be printed in the standard output.

## Running the software as a web service
To run this software as a web service, just run its _.jar_ file with no parameters.

The service will listen for incoming requests at http://localhost:8080, use method /sortAccessions via HTTP GET request with the list of accesions to sort and collapse, either from your browser or in the terminal using _curl_

```vim
curl http://localhost:8080/sortAccessions?accessions=A00000,A0001,ERR000111,ERR000112,ERR000113,ERR000115,ERR000116,ERR100114,ERR200000001,ERR200000002,ERR200000003,DRR2110012,SRR211001,ABCDEFG1
```
