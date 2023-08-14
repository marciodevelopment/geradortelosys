package br.org.curitiba.ici.saude.usuario.entities.view;

import br.org.curitiba.ici.saude.usuario.entities.types.SexoType;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class UsuarioPesquisaView {
  private Integer cdUsuario;
  private String nmUsuario;
  private String nmMae;
  private SexoType idSexo;

}
