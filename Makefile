all: comp run_tests

comp:
	javac *.java

run_tests: 
	java cal tests/test1.cal
	java cal tests/test2.cal
	java cal tests/test3.cal
	java cal tests/test4.cal
	java cal tests/test5.cal

run_test1:
	java cal tests/test1.cal

run_test2:
	java cal tests/test2.cal

run_test3:
	java cal tests/test3.cal

run_test4:
	java cal tests/test4.cal

run_test5:
	java cal tests/test5.cal

clean:
	rm -f *.class
