# Compilers Project

The project has been set up for Java and Gitlab CI.
You will find all documentation in the _docs_ folder and the source code in _src_.
The Java JUnit test will be automatically run when you commit to Gitlab.



### Forking the Repository
To create a fork of this repository, click on the *fork* button on the original repository at <https://gitlab.cs.wallawalla.edu/cptr354/lab_compiler>.
Copy the URL of your forked repository by clicking the clipboard icon next to it.
The URL should look something like: 

```
git@gitlab.cs.wallawalla.edu:YourUsername/lab_compiler.git
```

Once you have forked the repository, you must set its visibilty level to private so that only you can see it.
To do this, 
1. Click on the gear icon at the top right of the project page in GitLab.
2. Select *Edit Project* from the drop-down menu.
3. Set the *Visibility Level* to *Private* in the *Project settings* box.
4. Scroll down until you find the green *Save changes* button and click it.


### Setting Up Your Local Workspace
Create your local workspace by cloning the repository to your machine.
Put the repository in a place will remember.
You can clone the repository by using a command similar to this:

```
git clone git@gitlab.cs.wallawalla.edu:YourUsername/lab_compiler.git
```

If you are asked to enter a password, you need to set up your ssh key.

```
ssh-keygen
more ~/.ssh/id_rsa.pub
```

Copy the generated public key in to GitLab under your profile ssh keys


Finally, to make sure that you can receive updates easily (see below), type the 
following commands in the command window at the bottom of the Cloud 9 screen.

```
git remote add upstream git@gitlab.cs.wallawalla.edu:cptr354/lab_compiler.git
```
## Getting started

Fork this project on gitlab and then clone your fork to your computer.
Once you have it cloned, start eclipse and import an _existing maven project_.
Now you are ready to start working on **assignment_1** in the _docs_ folder.

Every time you commit code and push it to gitlab, the test will be automatically executed.
You can find the results by look at the **CI/CD** menu option.
It will list the recent jobs executed and show there status.
You can find the details of each job by clicking on them.


## Running test

The test will automatically be recognized by gitlab and your java editor.
In Eclipse, you can simply run **edu.wallawalla.cs.classes.cptr354.lexer.KeywordTokenTest.java** as _JUnit_ (the file is located in _src/test/java_).
There are several tests listed in JUnit from various files.


## Executing the program

The project uses Apache Maven to compile and run the project.
This is all done through the command line. 

Compile project to byte code and output to the target directory:
```
mvn compile
```

Compile and package project into a jar and output to the target directory:
```
mvn package
```

Execute main in Oberon.java with the possibility of adding arguments such as files to be opened.
There are text files that exist in the project `oberon_program_1.txt` and `constant.txt` located in _src/test/resources_.
The first file has an `INCLUDE` statement for the second file.
If no file is specified, main will use standard input a.k.a `System.in`

**Note**: Project must be compiled first.
```
mvn exec:java [-Dexec.args="arguments"]
EXAMPLE:
mvn exec:java -Dexec.args="oberon.txt"
```

Remove target directory
```
mvn clean
```