

Invoking scalac manually works (adapt absolute paths to your environment):

```bash

scalac  -java-output-version:17 \
        -bootclasspath \
        /Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala-library/2.13.14/f8b4afe89abe48ca670f620c7da89b71f93e6546/scala-library-2.13.14.jar \
        -classpath \
        /Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala3-library_3/3.5.1/fad444125865e38c6a3870229f4a5d3e05c38ea8/scala3-library_3-3.5.1.jar:/Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala-library/2.13.14/f8b4afe89abe48ca670f620c7da89b71f93e6546/scala-library-2.13.14.jar:/Users/tibor/projects/tmp/scalap/lib/build/classes/java/main:/Users/tibor/projects/tmp/scalap/lib/build/classes/scala/main \
        /Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hello.scala /Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hellomacro.scala        

```

Gradle build fails with the following error:

```bash

2024-09-23T18:17:35.645+0200 [INFO] [org.gradle.api.internal.tasks.scala.ZincScalaCompiler] Compiling with Zinc Scala compiler.
2024-09-23T18:17:35.658+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompiler] Inputs(compilers: Compilers(scalac: Analyzing compiler (Scala 3.5.1), javaTools: sbt.internal.inc.javac.JavaTools$$anon$1@5353b30a), options: CompileOptions(classpath: [Lxsbti.VirtualFile;@24f38045, sources: [Lxsbti.VirtualFile;@24f2eae5, classesDirectory: /Users/tibor/projects/tmp/scalap/lib/build/classes/scala/main, scalacOptions: [Ljava.lang.String;@781acbef, javacOptions: [Ljava.lang.String;@361ffc05, maxErrors: 100, sourcePositionMapper: xsbti.compile.CompileOptions$1@e56a32b, order: Mixed, temporaryClassesDirectory: Optional.empty, converter: Optional.empty, stamper: Optional.empty, earlyOutput: Optional.empty), setup: Setup(perClasspathEntryLookup: org.gradle.api.internal.tasks.scala.ZincScalaCompiler$EntryLookup@3dc0d5c6, skip: false, cachePath: /Users/tibor/projects/tmp/scalap/lib/build/tmp/scala/compilerAnalysis/compileScala.analysis, cache: sbt.internal.inc.FreshCompilerCache@13ab3422, incrementalCompilerOptions: IncOptions(transitiveStep: 5, recompileAllFraction: 0.5, relationsDebug: false, apiDebug: false, apiDiffContextSize: 5, apiDumpDirectory: Optional.empty, classfileManagerType: Optional.empty, auxiliaryClassFiles: [Lxsbti.compile.AuxiliaryClassFiles;@61e9b205, useCustomizedFileManager: false, recompileOnMacroDef: Optional[false], useOptimizedSealed: false, storeApis: true, enabled: true, extra: {}, logRecompileOnMacro: true, externalHooks: xsbti.compile.DefaultExternalHooks@5a3c351b, ignoredScalacOptions: [Ljava.lang.String;@10fc005a, strictMode: false, allowMachinePath: true, pipelining: false), reporter: sbt.internal.inc.LoggedReporter@22bfcefe, progress: Optional.empty, earlyAnalysisStore: Optional.empty, extra: [Lxsbti.T2;@eea3936), previousResult: PreviousResult(analysis: Optional.empty, setup: Optional.empty))
2024-09-23T18:17:35.662+0200 [INFO] [org.gradle.api.internal.tasks.scala.ZincScalaCompiler] Prepared Zinc Scala inputs: 0.016 secs
2024-09-23T18:17:35.775+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] [zinc] IncrementalCompile -----------
2024-09-23T18:17:35.777+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] IncrementalCompile.incrementalCompile
2024-09-23T18:17:35.779+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] previous = Stamps for: 0 products, 0 sources, 0 libraries
2024-09-23T18:17:35.779+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] current source = Set(/Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hello.scala, /Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hellomacro.scala)
2024-09-23T18:17:35.790+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] > initialChanges = InitialChanges(Changes(added = Set(/Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hello.scala, /Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hellomacro.scala), removed = Set(), changed = Set(), unmodified = ...),Set(),Set(),API Changes: Set())
2024-09-23T18:17:35.792+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] Full compilation, no sources in previous analysis.
2024-09-23T18:17:35.792+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] all 2 sources are invalidated
2024-09-23T18:17:35.795+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] Initial set of included nodes: 
2024-09-23T18:17:35.797+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] Recompiling all sources: number of invalidated sources > 50.0 percent of all sources
2024-09-23T18:17:35.797+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] compilation cycle 1
2024-09-23T18:17:35.802+0200 [INFO] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] compiling 2 Scala sources to /Users/tibor/projects/tmp/scalap/lib/build/classes/scala/main ...
2024-09-23T18:17:35.805+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] Returning already retrieved and compiled bridge: /Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala3-sbt-bridge/3.5.1/621e3117a799b8a9383ee236ee593e9b7330dfc8/scala3-sbt-bridge-3.5.1.jar.
2024-09-23T18:17:35.885+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] [zinc] Running cached compiler 36826077 for Scala Compiler version 3.5.1
2024-09-23T18:17:36.063+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] [zinc] The Scala compiler is invoked with:
        -deprecation
        -unchecked
        -java-output-version:17
        -explain
        -verbose
        -bootclasspath
        /Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala-library/2.13.14/f8b4afe89abe48ca670f620c7da89b71f93e6546/scala-library-2.13.14.jar
        -classpath
        /Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala3-library_3/3.5.1/fad444125865e38c6a3870229f4a5d3e05c38ea8/scala3-library_3-3.5.1.jar:/Users/tibor/.gradle/caches/modules-2/files-2.1/org.scala-lang/scala-library/2.13.14/f8b4afe89abe48ca670f620c7da89b71f93e6546/scala-library-2.13.14.jar:/Users/tibor/projects/tmp/scalap/lib/build/classes/java/main:/Users/tibor/projects/tmp/scalap/lib/build/classes/scala/main
....
2024-09-23T18:17:37.073+0200 [QUIET] [system.out] 17.0.10
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.prefs
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jlink
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.management.rmi
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jpackage
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.zipfs
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.desktop
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.localedata
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.naming
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jdeps
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.sql.rowset
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.net
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.transaction.xa
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.base
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.attach
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.dynalink
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jdwp.agent
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.scripting
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.sql
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.xml.dom
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.javadoc
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.internal.opt
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.unsupported
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.crypto.ec
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jartool
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.nio.mapmode
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jstatd
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.datatransfer
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.naming.dns
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.net.http
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.instrument
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.editpad
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jsobject
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.management.jfr
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.logging
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.security.sasl
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.unsupported.desktop
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.rmi
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.crypto.cryptoki
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.jconsole
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.naming.rmi
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.random
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.management.agent
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] java.xml
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.compiler
2024-09-23T18:17:37.074+0200 [QUIET] [system.out] jdk.internal.ed
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] java.management
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.jshell
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.security.jgss
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.sctp
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] java.compiler
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.internal.jvmstat
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] java.smartcardio
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.internal.le
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.jdi
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.charsets
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] java.security.jgss
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.security.auth
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.accessibility
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.httpserver
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] java.xml.crypto
2024-09-23T18:17:37.075+0200 [QUIET] [system.out] jdk.management
2024-09-23T18:17:37.076+0200 [QUIET] [system.out] jdk.jfr
2024-09-23T18:17:37.088+0200 [ERROR] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] [Error] /Users/tibor/projects/tmp/scalap/lib/src/main/scala/org/example/hello.scala:7:10: Macro code depends on class HttpClient in package java.net.http found on the classpath, but could not be loaded while evaluating the macro.
  This is likely because class files could not be found in the classpath entry for the symbol.

  A possible cause is if the origin of this symbol was built with pipelined compilation;
  in which case, this problem may go away by disabling pipelining for that origin.

  class HttpClient is defined in file /modules/java.net.http/java/net/http/HttpClient.class
2024-09-23T18:17:37.092+0200 [INFO] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] [Info] : [inlining  in 34ms]
2024-09-23T18:17:37.093+0200 [ERROR] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] one error found
2024-09-23T18:17:37.095+0200 [DEBUG] [org.gradle.api.internal.tasks.scala.ZincScalaCompilerFactory] Compilation failed
```


It seems that actual Zinc configuration has to differ, because the manual invocation of scalac works.