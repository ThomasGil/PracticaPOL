package Modelo.hibernate;
// Generated 30/05/2018 02:43:43 PM by Hibernate Tools 4.3.1



/**
 * FilaId generated by hbm2java
 */
public class FilaId  implements java.io.Serializable {


     private int idUsuario;
     private int idTarea;

    public FilaId() {
    }

    public FilaId(int idUsuario, int idTarea) {
       this.idUsuario = idUsuario;
       this.idTarea = idTarea;
    }
   
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public int getIdTarea() {
        return this.idTarea;
    }
    
    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FilaId) ) return false;
		 FilaId castOther = ( FilaId ) other; 
         
		 return (this.getIdUsuario()==castOther.getIdUsuario())
 && (this.getIdTarea()==castOther.getIdTarea());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdUsuario();
         result = 37 * result + this.getIdTarea();
         return result;
   }   


}


