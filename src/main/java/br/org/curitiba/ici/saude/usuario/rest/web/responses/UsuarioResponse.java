package br.org.curitiba.ici.saude.usuario.rest.web.responses;

import br.org.curitiba.ici.saude.usuario.entities.types.SexoType;
import lombok.Data;
import lombok.NoArgsConstructor;


                                                                                                        

@NoArgsConstructor
@Data
public class UsuarioResponse {
  private Integer    cdUsuario ;
  private String     nmUsuario ;
  private String     nmMae ;
  private String     nmPai ;
  private SexoType idSexo; 

}
