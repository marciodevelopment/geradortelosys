package br.org.curitiba.ici.saude.usuario.rest.web.requests;

import br.org.curitiba.ici.saude.common.ParametrosPesquisaRequest;
import br.org.curitiba.ici.saude.usuario.entities.types.SexoType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


                                                                    

@NoArgsConstructor
@Setter
@Getter
public class UsuarioPesquisaRequest extends ParametrosPesquisaRequest {
  private String     nmUsuario ;
  private String     nmMae ;
  private SexoType idSexo; 

}
