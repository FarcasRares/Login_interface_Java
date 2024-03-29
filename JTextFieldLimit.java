import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

class JTextFieldLimit extends PlainDocument {
	   private int limit;
	   JTextFieldLimit(int limit) {
	      super();
	      this.limit = limit;
	   }
	   JTextFieldLimit(int limit, boolean upper) {
	      super();
	      this.limit = limit;
	   }
	   public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
	      if (str == null)
	         return;
	      if ((getLength() + str.length()) <= limit) {
	         super.insertString(offset, str, attr);
	      }
	   }
}
