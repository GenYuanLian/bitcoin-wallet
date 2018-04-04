
.PHONY:clean distclean test

BIN      = libLyraZ.so

CC       = gcc
LIBS     = 
CIFLAGS  =  -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include -I/usr/lib/jvm/java-1.8.0-openjdk-amd64/include/linux

CXXFLAGS = -Wall -g  -fPIC -shared  $(CIFLAGS)
CFLAGS   = $(CIFLAGS) -fPIC -shared

ROOTSRC  = $(wildcard *.c) $(wildcard *.cpp)
ROOTOBJ  = $(patsubst %c,%o,$(patsubst %cpp,%o,$(ROOTSRC)))

SUBDIR   = $(shell ls -d */)
SUBSRC   = $(shell find $(SUBDIR) -name '*.c') $(shell find $(SUBDIR) -name '*.cpp')
SUBOBJ   = $(patsubst %c,%o,$(patsubst %cpp,%o,$(SUBSRC)))

$(BIN):$(ROOTOBJ) $(SUBOBJ)
	$(CC) $(CXXFLAGS) $(ROOTOBJ) $(SUBOBJ) -o $(BIN) $(LIBS)
	# rm -rf $(ROOTOBJ) $(SUBOBJ)

clean:
	rm -rf $(ROOTOBJ) $(SUBOBJ)

distclean:
	rm -rf $(BIN) $(ROOTOBJ) $(SUBOBJ)
