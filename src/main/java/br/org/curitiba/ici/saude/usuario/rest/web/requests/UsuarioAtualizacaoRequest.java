package br.org.curitiba.ici.saude.usuario.rest.web.requests;

import br.org.curitiba.ici.saude.usuario.entities.types.SexoType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Data
public class UsuarioAtualizacaoRequest {
  @NotNull
  @Size(min = 5, max = 255, message = "Nome")
  private String nmUsuario;
  @NotNull
  @Size(min = 5, max = 255, message = "Nome Mãe")
  private String nmMae;
  private String nmPai;
  @NotNull(message = "Sexo")
  private SexoType idSexo;

}
