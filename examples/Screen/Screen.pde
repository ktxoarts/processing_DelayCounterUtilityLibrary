import ktxo.art.processing.util.*;


LoopCounter backCounter = new LoopCounter(0, 0, 255, 1,  true); 
LoopCounter textCounter = new LoopCounter(255, 255, 0, 5,  true); 
LoopCounter textCounterNL = new LoopCounter(255, 255, 0, 1,  false); 


void setup() {
  size(400,400);
  smooth();
  frameRate(5);
}

void draw() {
  background(backCounter.next());
  text(String.format("Background LoopCounter, value=%.1f",backCounter.getCurrentValue()) , 40, 100);
  fill(textCounter.next());
  text(String.format("Text LoopCounter, value=%.1f",textCounter.getCurrentValue()) , 40, 200);
  fill(textCounterNL.next());
  text(String.format("Text LoopCounter No Loop, value=%.1f",textCounterNL.getCurrentValue()) , 40, 300);

}
