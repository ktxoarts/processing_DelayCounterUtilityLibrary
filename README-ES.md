([English version](README.md))

#  Libreria para Processing 3, incluyendo Delay (Demoras) y Counter (Contadores)




## Ejemplo:

```

import ktxo.art.processing.util.*;

// Contador que que incrementa de 0 a 255 incrementando 1: 0,1,2,....255,254,253,....,0,1....

LoopCounter backCounter = new LoopCounter(0, 0, 255, 1,  true); 

void setup() {
  size(400,400);
  frameRate(5);
}

void draw() {
  // Change background, loop between 0 and 255
  background(backCounter.next());
  
}
```

Ver tambien [examples/Screen/Screen.pde](examples/Screen/Screen.pde)

![Screen](examples/example.gif)

## Instalacion

1. Descargar la ultima version de [](TBD)
2. Agregar la libreria al IDE de Processing siguiendo las intrucciones de [How to Install a Contributed Library](https://github.com/processing/processing/wiki/How-to-Install-a-Contributed-Library)