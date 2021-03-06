package code.pragmatis.arandroid;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArFragment arFragment;
    public ModelRenderable catRenderable, dogRenderable, elephantRendelable,
            ferretRenderable, hippopotamusRenderable, horseRenderable,
            koalaRenderable, lionRendelable, rendeerRenderable,
            wolverineRendelable;
    ImageView cat, dog, elephant, ferret, hippopotamus, horse, koala, lion, reindeer, wolverine;
    View arrayView[];

    int selected = 1; //Default selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        //View
        cat = (ImageView) findViewById(R.id.cat);
        dog = (ImageView) findViewById(R.id.dog);
        elephant = (ImageView) findViewById(R.id.elephant);
        ferret = (ImageView) findViewById(R.id.ferret);
        hippopotamus = (ImageView) findViewById(R.id.hippopotamus);
        horse = (ImageView) findViewById(R.id.horse);
        koala = (ImageView) findViewById(R.id.koala);
        lion = (ImageView) findViewById(R.id.lion);
        wolverine = (ImageView) findViewById(R.id.wolverine);

        setArrayView();

        setClickListener();

        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode, selected);
            }
        });
    }

    private void setupModel() {
        ModelRenderable.builder()
                .setSource(this, R.raw.cat)
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.dog)
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.elephant)
                .build().thenAccept(renderable -> elephantRendelable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.ferret)
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.hippopotamus)
                .build().thenAccept(renderable -> hippopotamusRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.horse)
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.koala_bear)
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.lion)
                .build().thenAccept(renderable -> lionRendelable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable.builder()
                .setSource(this, R.raw.wolverine)
                .build().thenAccept(renderable -> wolverineRendelable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast.makeText(this, "Gagal memuat", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1) {
            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());
            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();

            addName(anchorNode, cat, "Cat");
        }

        if (selected == 2) {
            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());
            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();

            addName(anchorNode, dog, "Dog");
        }

        if (selected == 3) {
            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());
            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRendelable);
            elephant.select();

            addName(anchorNode, elephant, "Elephant");
        }

        if (selected == 4) {
            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());
            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();

            addName(anchorNode, ferret, "Ferret");
        }

        if (selected == 5) {
            TransformableNode hippopotamus = new TransformableNode(arFragment.getTransformationSystem());
            hippopotamus.setParent(anchorNode);
            hippopotamus.setRenderable(hippopotamusRenderable);
            hippopotamus.select();

            addName(anchorNode, hippopotamus, "Hippopotamus");
        }

        if (selected == 6) {
            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());
            horse.setParent(anchorNode);
            horse.setRenderable(horseRenderable);
            horse.select();

            addName(anchorNode, horse, "Horse");
        }

        if (selected == 7) {
            TransformableNode koala= new TransformableNode(arFragment.getTransformationSystem());
            koala.setParent(anchorNode);
            koala.setRenderable(koalaRenderable);
            koala.select();

            addName(anchorNode, koala, "Koala");
        }

        if (selected == 8) {
            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());
            lion.setParent(anchorNode);
            lion.setRenderable(lionRendelable);
            lion.select();

            addName(anchorNode, lion, "Lion");
        }

        if (selected == 9) {
            TransformableNode wolverine = new TransformableNode(arFragment.getTransformationSystem());
            wolverine.setParent(anchorNode);
            wolverine.setRenderable(wolverineRendelable);
            wolverine.select();

            addName(anchorNode, wolverine, "Wolverine");
        }
    }

    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
        //Set name of animals
        ViewRenderable.builder().setView(this, R.layout.name_animal)
                .build()
                .thenAccept(viewRenderable -> {
                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y+0.5f, 0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(viewRenderable);
                    nameView.select();

                    //Set text
                    TextView txt_name = (TextView)viewRenderable.getView();
                    txt_name.setText(name);

                    //Click to textview to remove animal
                    txt_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            anchorNode.setParent(null);
                        }
                    });
                });
    }

    private void setClickListener() {
        for (int i = 0; i < arrayView.length; i++)
            arrayView[i].setOnClickListener(this);
    }

    private void setArrayView() {
        arrayView = new View[]{
                cat, dog, elephant, ferret, hippopotamus, horse, koala, lion, wolverine
        };
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.cat){
            selected = 1;
            setBackground(v.getId());
        } else if (v.getId() == R.id.dog){
            selected = 2;
            setBackground(v.getId());
        } else if (v.getId() == R.id.elephant){
            selected = 3;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ferret){
            selected = 4;
            setBackground(v.getId());
        } else if (v.getId() == R.id.hippopotamus){
            selected = 5;
            setBackground(v.getId());
        } else if (v.getId() == R.id.horse){
            selected = 6;
            setBackground(v.getId());
        } else if (v.getId() == R.id.koala){
            selected = 7;
            setBackground(v.getId());
        } else if (v.getId() == R.id.lion){
            selected = 8;
            setBackground(v.getId());
        } else if (v.getId() == R.id.wolverine){
            selected = 9;
            setBackground(v.getId());
        }
    }

    private void setBackground(int id) {
        for (int i = 0; i < arrayView.length; i++) {
            if (arrayView[i].getId() == id) {
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639")); // Set background for selected animal
            } else {
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);
            }

        }
    }
}
