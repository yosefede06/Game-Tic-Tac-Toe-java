/**
 * The factory RenderFactory will be responsible for creating the appropriate rendering interface.
 */
public class RendererFactory {
    /** Creates an appropriate rendering interface.
     * Builds te
     * @param type String type of the rendering.
     * @param size Size of the render form.
     * @return A Renderer instance.
     */
    public Renderer buildRenderer(String type, int size) {
        Renderer renderer = null;
        switch(type) {
            case "console":
                renderer =  new ConsoleRenderer(size);
                break;
            case "none":
                renderer =  new VoidRenderer();
                break;
        }
        return renderer;
    }
}
