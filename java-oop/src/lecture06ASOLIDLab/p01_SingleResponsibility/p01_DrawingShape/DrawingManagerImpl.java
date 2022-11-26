package lecture06ASOLIDLab.p01_SingleResponsibility.p01_DrawingShape;

import lecture06ASOLIDLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import lecture06ASOLIDLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import lecture06ASOLIDLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Rengerer;
import lecture06ASOLIDLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Rengerer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Rengerer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        shape.draw(this.renderer, this.drawingRepository);
    }
}
