public class EvaluationException extends RuntimeException {
   
  public EvaluationException(String msg) {
    super("*** Evaluation error." + msg);
  }
  
}