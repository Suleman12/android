package com.example.animatedmodle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.SkeletonNode;
import com.google.ar.sceneform.animation.ModelAnimator;
import com.google.ar.sceneform.rendering.AnimationData;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ModelAnimator modelAnimator;
    private ModelRenderable bearRenderable;
    private ModelRenderable catRenderable;
    private ModelRenderable cowRenderable;
    private ModelRenderable dogRenderable;
    private ModelRenderable elephantRenderable;
    private ModelRenderable ferretRenderable;
    private ModelRenderable hippopotamusRenderable;
    private ModelRenderable horseRenderable;
    private ModelRenderable koala_bearRenderable;
    private ModelRenderable lionRenderable;
    private ModelRenderable reindeerRenderable;
    private ModelRenderable wolverineRenderable;

    ImageView bear, cat, cow, dog, elephent, ferret, hippopotamus, horse, koala_bear, lion, reindeer, wolverine;

    View arrayView[];



    private int selected = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArFragment arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.arfragment);

        bear = (ImageView) findViewById(R.id.bear);
        cat = (ImageView) findViewById(R.id.cat);
        dog = (ImageView) findViewById(R.id.dog);
        cow = (ImageView) findViewById(R.id.cow);
        elephent = (ImageView) findViewById(R.id.elephant);
        ferret = (ImageView) findViewById(R.id.ferret);
        hippopotamus = (ImageView) findViewById(R.id.hippopotamus);
        horse = (ImageView) findViewById(R.id.horse);
        koala_bear = (ImageView) findViewById(R.id.koala_bear);
        lion = (ImageView) findViewById(R.id.lion);
        reindeer = (ImageView) findViewById(R.id.reindeer);
        wolverine = (ImageView) findViewById(R.id.wolverine);


        setArrayView();
        setClickListener();
        setupModel();


        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {


                Anchor anchor = hitResult.createAnchor();
                //  createModel(hitResult.createAnchor(), arFragment);
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());

                createModel(anchorNode, selected, arFragment);

            }
        });


    }

    private void setupModel() {
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("bear.sfb"))
                .build()
                .thenAccept(modelRenderable -> bearRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead bear", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("cat.sfb"))
                .build()
                .thenAccept(modelRenderable -> catRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );


        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("cow.sfb"))
                .build()
                .thenAccept(modelRenderable -> cowRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("dog.sfb"))
                .build()
                .thenAccept(modelRenderable -> dogRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );

        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("elephant.sfb"))
                .build()
                .thenAccept(modelRenderable -> elephantRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("ferret.sfb"))
                .build()
                .thenAccept(modelRenderable -> ferretRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("hippopotamus.sfb"))
                .build()
                .thenAccept(modelRenderable -> hippopotamusRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("horse.sfb"))
                .build()
                .thenAccept(modelRenderable -> horseRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("koala_bear.sfb"))
                .build()
                .thenAccept(modelRenderable -> koala_bearRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("lion.sfb"))
                .build()
                .thenAccept(modelRenderable -> lionRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead  model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("reindeer.sfb"))
                .build()
                .thenAccept(modelRenderable -> reindeerRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to lead model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
        ModelRenderable
                .builder()
                .setSource(this, Uri.parse("wolverine.sfb"))
                .build()
                .thenAccept(modelRenderable -> wolverineRenderable = modelRenderable)
                .exceptionally(throwable -> {


                            Toast.makeText(this, "Unable to load Model", Toast.LENGTH_SHORT).show();
                            return null;
                        }
                );
    }

    private void createModel(AnchorNode anchor, int selected, ArFragment arFragment) {

        if (selected == 1) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(bearRenderable);
            bear.select();
        }

        if (selected == 2) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(catRenderable);
            bear.select();
        }
        if (selected == 3) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(cowRenderable);
            bear.select();
        }
        if (selected == 4) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(dogRenderable);
            bear.select();
        }
        if (selected == 5) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(elephantRenderable);
            bear.select();
        }
        if (selected == 6) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(ferretRenderable);
            bear.select();
        }
        if (selected == 7) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(hippopotamusRenderable);
            bear.select();
        }
        if (selected == 8) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(horseRenderable);
            bear.select();
        }
        if (selected == 9) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(koala_bearRenderable);
            bear.select();
        }
        if (selected == 10) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(lionRenderable);
            bear.select();
        }
        if (selected == 11) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(reindeerRenderable);
            bear.select();
        }
        if (selected == 12) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchor);
            bear.setRenderable(wolverineRenderable);
            bear.select();
        }
    }



       /* ModelRenderable
                .builder()
                .setSource(this, Uri.parse("bear.sfb"))
                .build()
                .thenAccept(modelRenderable -> {
                    AnchorNode anchorNode = new AnchorNode(anchor);
                    SkeletonNode skeletonNode = new SkeletonNode();
                    skeletonNode.setParent(anchorNode);
                    skeletonNode.setRenderable(modelRenderable);
                    arFragment.getArSceneView().getScene().addChild(anchorNode);*/
    //   Button enabler = findViewById(R.id.button);
    //  enabler.setOnClickListener(v -> animateModel(modelRenderable));
    //  });


    private void setClickListener() {
        for (int i = 0; i < arrayView.length; i++) {

           arrayView[i].setOnClickListener(this);
        }

    }

    private void setArrayView() {

        arrayView = new View[]
                {
                        bear, cat, cow, dog, elephent, ferret, hippopotamus, horse, koala_bear, lion, reindeer, wolverine
                };
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bear)
        {
            selected=1;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.cat)
        {
            selected=2;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.cow)
        {
            selected=3;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.dog)
        {
            selected=4;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.elephant)
        {
            selected=5;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.ferret)
        {
            selected=6;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.hippopotamus)
        {
            selected=7;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.horse)
        {
            selected=8;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.koala_bear)
        {
            selected=9;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.lion)
        {
            selected=10;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.reindeer)
        {
            selected=11;
            setBackground(view.getId());
        }
        else  if (view.getId()==R.id.wolverine)
        {
            selected=12;
            setBackground(view.getId());
        }

    }

    public void setBackground(int id)
    {
        for(int i=0;i<arrayView.length;i++)
        {

            if(arrayView[i].getId()==id)
                arrayView[i].setBackgroundColor(Color.parseColor("#80333639"));
            else
                arrayView[i].setBackgroundColor(Color.TRANSPARENT);

        }
    }










/*
    private void animateModel(ModelRenderable mr){
        if(modelAnimator!=null&&modelAnimator.isRunning())
            modelAnimator.end();
        int animationCount=mr.getAnimationDataCount();
        if(i==animationCount)
            i=0;
        AnimationData animationData=mr.getAnimationData(i);
        modelAnimator=new ModelAnimator(animationData,mr);
        modelAnimator.start();
        i++;
    }

    */
}








