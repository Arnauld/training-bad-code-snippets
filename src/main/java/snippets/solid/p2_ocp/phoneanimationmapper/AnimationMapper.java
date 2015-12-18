package snippets.solid.p2_ocp.phoneanimationmapper;

/**
 * @author <a href="http://twitter.com/aloyer">@aloyer</a>
 */
public interface AnimationMapper {
    Animation getAnimation(Place oldPlace, Place newPlace);
}
