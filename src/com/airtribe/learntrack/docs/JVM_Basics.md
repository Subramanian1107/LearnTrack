JDK : 

JDK stands for Java Development Kit which is a software development tool used to develop java applications. It contains various tools for compiling and debugging. It contains multiple libraries and the JRE.
JDK is used to compile and run java programs.
JRE : 

JRE stands for Java Runtime Environment which provides the environment required to run java programs. It contains JVM and core libraries but not the compilers that JDK has.

JVM :

JVM stands for Java Virtual Machine which is an abstract machine that executes Java bytecode. It converts bytecode into machine-specific instructions and manages memory, garbage collection, and security.

ByteCode : 

Bytecode is an intermediate, platform-independent code generated when a Java program is compiled by the JDK. The Java compiler converts .java source files into .class files containing bytecode, which can be executed on any system that has a JVM.

For example:
java example.java gives example.class which is the bytecode. this can be used by any machine to run the program, provided it has the same JVM installed.


Write Once, Run Anywhere:

“Write once, run anywhere” means that a Java program written and compiled on one platform can run on any other platform without modification, as long as a compatible JVM is available. The same bytecode works across Windows, macOS, and Linux.