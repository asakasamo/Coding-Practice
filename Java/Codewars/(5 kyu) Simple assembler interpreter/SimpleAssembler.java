import java.util.*;

public class SimpleAssembler {
  
  private Map<String, Integer> registers;
  private List<Instruction> callStack;
  
  //our starting point
  public static Map<String, Integer> interpret(String[] program){
    SimpleAssembler assembler = SimpleAssembler.instance();
    return assembler.interpretProgram(program);
  }
  
  public SimpleAssembler() {
    registers = new HashMap<String, Integer>();
    callStack = new ArrayList<Instruction>();
  }
  
  public static SimpleAssembler instance() {
    return new SimpleAssembler();
  }
  
  public Map<String, Integer> interpretProgram(String[] program) {
    //fill the call stack
    for(int i = 0; i < program.length; i++){
      callStack.add(new Instruction(program[i]));
    }
    
    //print the call stack
    for(int i = 0; i < program.length; i++){
      System.out.println(i + ". " + callStack.get(i));
    }
    System.out.println();
    
    //execute the call stack
    int nextPosition = 0;
    while(nextPosition > -1 && nextPosition < callStack.size()){
      nextPosition += callStack.get(nextPosition).execute();
    }
    
    return registers;
  }
  
  private class Instruction {
    String name;
    String param1;
    String param2;
    
    public Instruction(String def){
      String[] parts = def.split(" ");
      name = parts[0];
      param1 = parts[1];
      param2 = parts.length > 2 ? parts[2] : null;
    } 
   
    public int execute() {
//       print();
      int modifier = 1;
      
      if(name.equals("mov")) {
        if(param2.chars().allMatch(Character::isLetter)) { //if param2 is a register
          registers.put(param1, registers.get(param2));
        }
        else registers.put(param1, Integer.parseInt(param2));
      }
      else if(name.equals("inc")) {
        registers.put(param1, registers.get(param1) + 1);
      }
      else if(name.equals("dec")) {
        registers.put(param1, registers.get(param1) - 1);
      }
      else if(name.equals("jnz")) {
        int x;
        if(param1.chars().allMatch(Character::isLetter)) { //if param1 is a register
          x = registers.get(param1);
        }
        else {
          x = Integer.parseInt(param1);
        }
        
        if(x != 0) {
          modifier = Integer.parseInt(param2);
        }
      }
      
      return modifier;
    }
    
    public void print() {
      System.out.println(this);
    }
    
    public String toString() {
      return "Name: " + name + ", p1: " + param1 + ", p2: " + param2;
    }
  }
}