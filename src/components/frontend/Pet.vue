<template>
  <div class="jiggly puffed" @click="play">
    <div class="jiggly-body-upper">
      <div class="jiggly-body"></div>
      <div class="jiggly-ear jiggly-ear-left"></div>
      <div class="jiggly-ear jiggly-ear-right"></div>
      <div class="jiggly-puff"></div>
      <div class="jiggly-face">
        <div class="jiggly-eye jiggly-eye-left">
          <div class="jiggly-eye-pupil"></div>
          <div class="jiggly-eye-lid"></div>
        </div>
        <div class="jiggly-eye jiggly-eye-right">
          <div class="jiggly-eye-pupil"></div>
          <div class="jiggly-eye-lid"></div>
        </div>
        <div class="jiggly-blush jiggly-blush-left"></div>
        <div class="jiggly-blush jiggly-blush-right"></div>
        <div class="jiggly-mouth">
          <div class="jiggly-mouth-singing"></div>
        </div>
      </div>
      <div class="jiggly-arm jiggly-arm-left">
        <div class="jiggly-marker"></div>
      </div>
      <div class="jiggly-arm-right-wrapper">
        <div class="jiggly-arm jiggly-arm-right"></div>
      </div>
    </div>
    <div class="jiggly-leg jiggly-leg-left"></div>
    <div class="jiggly-leg jiggly-leg-right"></div>
    <div class="jiggly-music-notes">
      <div class="jiggly-music-note jiggly-music-note-one"></div>
      <div class="jiggly-music-note jiggly-music-note-two"></div>
      <div class="jiggly-music-note jiggly-music-note-three"></div>
    </div>
  </div>

  <audio ref="babalaAudio" :src="babala"></audio>
</template>

<script setup lang="ts">
import { ref } from "vue";
import babala from "@/assets/voice/babala.mp3";

const babalaAudio = ref<HTMLAudioElement | null>(null);

const play = () => {
  if (!babalaAudio.value) return;

  babalaAudio.value.play()
};
</script>

<style scoped>
.jiggly {
  height: 10rem;
  width: 10rem;
  font-size: 1rem;
  position: absolute;
  bottom: 10%;
  left: -35%;
  transform: rotate(-5deg);
}

.jiggly-body {
  position: absolute;
  z-index: 2;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  border-radius: 50%;
  background-color: #ffcdc5;
  transition: 0.5s ease-in-out;
}

.jiggly-body-upper {
  position: relative;
  z-index: 2;
  height: 100%;
  width: 100%;
}

.jiggly-ear {
  position: absolute;
  z-index: 1;
  bottom: calc(100% - 4.25em);
  height: 4em;
  width: 2.5em;
  background-color: #ffcdc5;
  transform-origin: bottom center;
  transition: 0.5s ease-in-out;
}

.jiggly-ear::after {
  content: "";
  position: absolute;
  bottom: 0;
  height: 70%;
  width: 60%;
  background-color: #6a5262;
}

.jiggly-ear-left {
  left: 0;
  border-top-left-radius: 80% 0.5em;
  border-top-right-radius: 80% 0.5em;
  border-bottom-left-radius: 0.5em 80%;
  transform: skewY(10deg);
}

.jiggly-ear-left::after {
  left: 15%;
  border-top-left-radius: 0.25em;
}

.jiggly-ear-right {
  right: 0;
  border-top-left-radius: 80% 0.5em;
  border-top-right-radius: 80% 0.5em;
  border-bottom-right-radius: 0.5em 80%;
  transform: skewY(-10deg);
}

.jiggly-ear-right::after {
  right: 15%;
  border-top-right-radius: 0.25em;
}

.jiggly-puff {
  position: absolute;
  z-index: 5;
  top: -0.75em;
  left: 25%;
  height: 4.25em;
  width: 3.5em;
  transition: 0.5s cubic-bezier(0.35, -0.1, 0.35, 2);
}

.jiggly-puff::before,
.jiggly-puff::after {
  content: "";
  position: absolute;
}

.jiggly-puff::before {
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  border-top-left-radius: 50% 40%;
  border-top-right-radius: 50% 30%;
  border-bottom-left-radius: 50%;
  border-bottom-right-radius: 50% 30%;
  border-bottom: solid 3px #ffbab3;
  border-left: solid 3px #ffbab3;
  background-color: #ffcdc5;
  transform: skew(-10deg);
}

.jiggly-puff::after {
  z-index: 6;
  right: -5%;
  bottom: 15%;
  height: 2.5em;
  width: 1.5em;
  border-radius: 50%;
  border-right: solid 3px #ffbab3;
  transform: rotate(65deg);
}

.jiggly-face {
  position: relative;
  z-index: 4;
  height: 100%;
  width: 100%;
  border-radius: 50%;
  overflow: hidden;
  transition: 0.5s ease-in-out;
}

.jiggly-eye {
  position: absolute;
  z-index: 2;
  top: 3.75em;
  height: 3.25em;
  width: 3.25em;
  border-radius: 50%;
  background-color: #fff;
  transform-origin: center 70%;
  -webkit-animation-name: blinky;
  animation-name: blinky;
  -webkit-animation-duration: 5s;
  animation-duration: 5s;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
}

.jiggly-eye-pupil {
  position: absolute;
  left: 50%;
  top: 50%;
  height: 75%;
  width: 75%;
  background-color: #10b4ee;
  border-radius: 50%;
  transform: translate(-50%, -50%);
  overflow: hidden;
}

.jiggly-eye-pupil::before,
.jiggly-eye-pupil::after {
  content: "";
  position: absolute;
  border-radius: 50%;
}

.jiggly-eye-pupil::before {
  left: 5%;
  top: 0;
  height: 75%;
  width: 75%;
  background-color: #1873c5;
}

.jiggly-eye-pupil::after {
  left: 15%;
  top: 15%;
  height: 35%;
  width: 35%;
  background-color: #fff;
}

.jiggly-eye-lid {
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
}

.jiggly-eye-lid::before,
.jiggly-eye-lid::after {
  content: "";
  position: absolute;
  transform: scaleX(1) rotate(0deg) translate(0, 0);
  opacity: 0;
  transition: transform 0.3s ease-in-out, opacity 0.2s 0.1s;
}

.jiggly-eye-lid::before {
  left: 0;
  bottom: 100%;
  height: 50%;
  width: 100%;
  border-bottom-left-radius: 50% 20%;
  border-bottom-right-radius: 50% 20%;
  border-bottom: solid 3px #ffbab3;
  background-color: #ffcdc5;
}

.jiggly-eye-lid::after {
  left: 0;
  top: 100%;
  height: 40%;
  width: 100%;
  border-top-left-radius: 50% 100%;
  border-top-right-radius: 50% 100%;
  border-top: solid 3px #ffbab3;
  background-color: #ffcdc5;
}

.jiggly-eye-left {
  left: 0.875em;
}

.jiggly-eye-right {
  right: 0.875em;
}

.jiggly-blush {
  position: absolute;
  z-index: 1;
  top: 6.625rem;
  height: 0.75rem;
  width: 1.5rem;
  border-radius: 50%;
  background-color: #f67b94;
  opacity: 0.3;
  transition: 0.35s ease-in-out;
}

.jiggly-blush-left {
  left: 0.75rem;
}

.jiggly-blush-right {
  right: 0.75rem;
}

.jiggly-mouth {
  position: absolute;
  z-index: 5;
  bottom: 2.75em;
  left: calc(50% - (1em / 2));
  width: 1em;
  height: 0.75em;
}

.jiggly-mouth::before,
.jiggly-mouth::after {
  content: "";
  position: absolute;
}

.jiggly-mouth::before {
  z-index: 100;
  height: 150%;
  width: 100%;
  border-radius: 50%;
  background-color: #a41020;
  transform: scaleY(0);
  transform-origin: top center;
}

.jiggly-mouth::after {
  top: 0;
  left: 0;
  width: calc(100% - 4px);
  height: 100%;
  border-bottom-left-radius: 0.75em 80%;
  border-bottom-right-radius: 0.75em 80%;
  border: solid 2px #a41020;
  border-top: 0;
  background-color: transparent;
  transform-origin: 70% center;
  transition: 0.3s ease-in-out;
}

.jiggly-arm {
  position: absolute;
  z-index: 10;
  top: 8em;
  height: 1.75em;
  width: 1em;
  border: solid 3px #ffbab3;
  border-top: 0;
  background-color: #ffcdc5;
  transform-origin: top center;
  transition: 0.45s ease-in-out;
  border-top-left-radius: 0.5em;
  border-top-right-radius: 0.5em;
  border-bottom-left-radius: 70% 100%;
  border-bottom-right-radius: 70% 100%;
}

.jiggly-arm-left {
  left: 1.25em;
  border-right: solid 1px #ffbab3;
  transform: rotate(60deg);
}

.jiggly-arm-right {
  border-left: solid 1px #ffbab3;
  transform: rotate(-60deg);
}

.jiggly-arm-right-wrapper {
  position: absolute;
  z-index: 10;
  top: 8em;
  right: 1.25em;
  height: 1.75em;
  width: 1em;
  transform-origin: top center;
}

.jiggly-arm-right-wrapper .jiggly-arm {
  top: 0;
  right: 0;
}

.jiggly-marker {
  position: absolute;
  top: calc(100% - 0.5em);
  left: -1em;
  height: 0.75em;
  width: 2em;
  border-radius: 0.25em;
  background-color: #6a5262;
}

.jiggly-marker::before,
.jiggly-marker::after {
  content: "";
  position: absolute;
}

.jiggly-marker::before {
  z-index: 1;
  left: -0.125em;
  top: calc(50% - 0.25em);
  height: 0.5em;
  width: 0.5em;
  border-bottom-left-radius: 2px;
  border-top-right-radius: 100%;
  background-color: #a41020;
  background-image: linear-gradient(45deg, black 0%, black 20%, #947589 20%, #947589 100%);
  transform: rotate(45deg);
}

.jiggly-marker::after {
  z-index: 2;
  right: calc(100% - 0.5em);
  top: -0.25em;
  height: 1.25em;
  width: 1.5em;
  border-radius: 0.25em;
  background-color: #52a48b;
  transition: 0.15s ease-out;
}

.jiggly-leg {
  position: absolute;
  z-index: 1;
  bottom: -1.75em;
  height: 2.5em;
  width: 1.25em;
  background-color: #ffbab3;
  transform-origin: top center;
  border-top-left-radius: 0.5em;
  border-top-right-radius: 0.5em;
  border-bottom-left-radius: 70% 100%;
  border-bottom-right-radius: 70% 100%;
}

.jiggly-leg-left {
  left: 3em;
  transform: rotate(50deg);
}

.jiggly-leg-right {
  right: 3em;
  transform: rotate(-50deg);
}

.jiggly-music-notes {
  position: absolute;
  z-index: 50;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  mix-blend-mode: overlay;
  cursor: pointer;
}

.jiggly-music-note {
  position: absolute;
  left: calc(50% - 0.625rem);
  top: calc(50% - 0.625rem);
  height: 1.25rem;
  width: 1.25rem;
  border: solid 3px currentColor;
  border-top-width: 6px;
  border-bottom: 0;
  color: #10b4ee;
  mix-blend-mode: overlay;
  opacity: 0;
}

.jiggly-music-note::before,
.jiggly-music-note::after {
  content: "";
  position: absolute;
  bottom: -0.25em;
  height: 0.5em;
  width: 0.75em;
  border-radius: 50%;
  background-color: currentColor;
  transform: rotate(-25deg);
}

.jiggly-music-note::before {
  right: 100%;
}

.jiggly-music-note::after {
  right: -3px;
}

.jiggly:hover .jiggly-body {
  transform: scale(1.2);
  transition: 0.15s 0.4s cubic-bezier(0.35, -0.1, 0.35, 2);
}

.jiggly:hover .jiggly-face {
  transform: translateY(0.5em);
  transition: 0.15s 0.2s ease-in;
}

.jiggly:hover .jiggly-ear {
  transition: 0.15s 0.4s cubic-bezier(0.35, -0.1, 0.35, 2);
}

.jiggly:hover .jiggly-ear-left {
  transform: translate(-0.5rem, -0.5rem) rotate(-5deg);
}

.jiggly:hover .jiggly-ear-right {
  transform: translate(0.5rem, -0.5rem) rotate(5deg);
}

.jiggly:hover .jiggly-puff {
  transform: scale(1.15);
}

.jiggly:hover .jiggly-eye .jiggly-eye-lid::before,
.jiggly:hover .jiggly-eye .jiggly-eye-lid::after {
  opacity: 1;
  transition: transform 0.3s ease-in-out, opacity 0.1s;
}

.jiggly:hover .jiggly-eye .jiggly-eye-lid::after {
  transition: transform 0.15s 0.3s ease-in-out, opacity 0.25s 0.1s;
}

.jiggly:hover .jiggly-eye-left .jiggly-eye-lid::before {
  transform: rotate(15deg) translate(0.5em, 0.75em) scaleX(1.2);
}

.jiggly:hover .jiggly-eye-left .jiggly-eye-lid::after {
  transform: rotate(15deg) translate(-1em, -1em) scaleX(1.2);
}

.jiggly:hover .jiggly-eye-right .jiggly-eye-lid::before {
  transform: rotate(-15deg) translate(-0.5em, 0.75em) scaleX(1.2);
}

.jiggly:hover .jiggly-eye-right .jiggly-eye-lid::after {
  transform: rotate(-15deg) translate(1em, -1em) scaleX(1.2);
}

.jiggly:hover .jiggly-blush {
  opacity: 0;
}

.jiggly:hover .jiggly-mouth::before {
  -webkit-animation-name: scaleMouthUp;
  animation-name: scaleMouthUp;
  -webkit-animation-duration: 0.6s;
  animation-duration: 0.6s;
}

.jiggly:hover .jiggly-mouth::after {
  border-bottom-left-radius: 0.75em 80%;
  border-bottom-right-radius: 0.75em 80%;
  border-left-color: transparent;
  border-right-color: transparent;
  transform: rotateX(180deg);
  transition: border-left-color 0s, border-right-color 0s, transform 0.6s ease-in-out;
}

.jiggly:hover .jiggly-arm {
  transition: 0.45s 0.15s ease-in-out;
}

.jiggly:hover .jiggly-arm-left {
  transform: translateX(-0.75rem) rotate(80deg);
}

.jiggly:hover .jiggly-arm-right {
  transform: translateX(0.75rem) rotate(-80deg);
}

.jiggly:hover .jiggly-marker::after {
  transform: translateX(-40em);
  transition: 0.3s 0.7s ease-in-out;
}

.jiggly:not(:hover) .jiggly-body-upper {
  -webkit-animation-name: rotateDance;
  animation-name: rotateDance;
  -webkit-animation-duration: 3s;
  animation-duration: 3s;
  -webkit-animation-delay: 2s;
  animation-delay: 2s;
  -webkit-animation-timing-function: ease-out;
  animation-timing-function: ease-out;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
}

.jiggly:not(:hover) .jiggly-mouth::after {
  height: 0px;
  transition: height 0.2s 2s, transform 0.3s ease-in-out;
  overflow: hidden;
}

.jiggly:not(:hover) .jiggly-mouth-singing {
  position: absolute;
  left: 0;
  top: 0;
  height: 100%;
  width: 100%;
  border-bottom-left-radius: 50% 80%;
  border-bottom-right-radius: 50% 80%;
  background-color: #a41020;
  transform-origin: top center;
  transform: scaleY(0);
  overflow: hidden;
  -webkit-animation-name: scaleMouthSinging;
  animation-name: scaleMouthSinging;
  -webkit-animation-duration: 2.5s;
  animation-duration: 2.5s;
  -webkit-animation-delay: 2s;
  animation-delay: 2s;
  -webkit-animation-timing-function: ease-out;
  animation-timing-function: ease-out;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
}

.jiggly:not(:hover) .jiggly-mouth-singing::after {
  content: "";
  position: absolute;
  bottom: -0.125em;
  right: -0.125em;
  height: 100%;
  width: 100%;
  border-radius: 50%;
  background-color: #f67b94;
}

.jiggly:not(:hover) .jiggly-arm-left {
  transform: rotateX(180deg) rotate(-120deg);
  transition: 0.45s 0.15s ease-in-out;
}

.jiggly:not(:hover) .jiggly-arm-right-wrapper {
  -webkit-animation-name: moveArmRight;
  animation-name: moveArmRight;
  -webkit-animation-duration: 7s;
  animation-duration: 7s;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
  -webkit-animation-timing-function: ease-in-out;
  animation-timing-function: ease-in-out;
}

.jiggly:not(:hover) .jiggly-music-notes {
  -webkit-animation-name: rotateNotes;
  animation-name: rotateNotes;
  -webkit-animation-duration: 10s;
  animation-duration: 10s;
  -webkit-animation-delay: 2s;
  animation-delay: 2s;
  -webkit-animation-iteration-count: infinite;
  animation-iteration-count: infinite;
  -webkit-animation-timing-function: ease-in-out;
  animation-timing-function: ease-in-out;
}

.jiggly:not(:hover) .jiggly-music-note-one {
  -webkit-animation: scaleNoteone 6s 3s ease-in-out infinite;
  animation: scaleNoteone 6s 3s ease-in-out infinite;
}

@-webkit-keyframes scaleNoteone {
  0% {
    transform: scale(1) translate(0, 0);
    opacity: 0;
  }

  5%,
  100% {
    transform: scale(1) translate(0, 0);
    opacity: 1;
  }

  50%,
  99.9% {
    transform: scale(1.2) translate(7em, -7em);
    opacity: 0;
  }
}

@keyframes scaleNoteone {
  0% {
    transform: scale(1) translate(0, 0);
    opacity: 0;
  }

  5%,
  100% {
    transform: scale(1) translate(0, 0);
    opacity: 1;
  }

  50%,
  99.9% {
    transform: scale(1.2) translate(7em, -7em);
    opacity: 0;
  }
}

.jiggly:not(:hover) .jiggly-music-note-two {
  -webkit-animation: scaleNotetwo 6s 4.5s ease-in-out infinite;
  animation: scaleNotetwo 6s 4.5s ease-in-out infinite;
}

@-webkit-keyframes scaleNotetwo {
  0% {
    transform: scale(1) translate(0, 0);
    opacity: 0;
  }

  5%,
  100% {
    transform: scale(1) translate(0, 0);
    opacity: 1;
  }

  50%,
  99.9% {
    transform: scale(1.2) translate(3em, 4em);
    opacity: 0;
  }
}

@keyframes scaleNotetwo {
  0% {
    transform: scale(1) translate(0, 0);
    opacity: 0;
  }

  5%,
  100% {
    transform: scale(1) translate(0, 0);
    opacity: 1;
  }

  50%,
  99.9% {
    transform: scale(1.2) translate(3em, 4em);
    opacity: 0;
  }
}

.jiggly:not(:hover) .jiggly-music-note-three {
  -webkit-animation: scaleNotetwo 6s 6s ease-in-out infinite;
  animation: scaleNotetwo 6s 6s ease-in-out infinite;
}

@keyframes scaleNotetwo {
  0% {
    transform: scale(1) translate(0, 0);
    opacity: 0;
  }

  5%,
  100% {
    transform: scale(1) translate(0, 0);
    opacity: 1;
  }

  50%,
  99.9% {
    transform: scale(1.2) translate(-7em, -9em);
    opacity: 0;
  }
}

@-webkit-keyframes scaleMouthUp {
  0% {
    transform: scaleY(0) translateY(100%);
  }

  100% {
    transform: scaleY(0);
  }

  50%,
  60% {
    transform: scaleY(1.1) translateY(0);
  }
}

@keyframes scaleMouthUp {
  0% {
    transform: scaleY(0) translateY(100%);
  }

  100% {
    transform: scaleY(0);
  }

  50%,
  60% {
    transform: scaleY(1.1) translateY(0);
  }
}

@-webkit-keyframes moveArmRight {

  0%,
  50%,
  100% {
    transform: rotate(0deg);
  }

  30% {
    transform: rotate(-20deg);
  }

  80% {
    transform: rotate(-40deg);
  }
}

@keyframes moveArmRight {

  0%,
  50%,
  100% {
    transform: rotate(0deg);
  }

  30% {
    transform: rotate(-20deg);
  }

  80% {
    transform: rotate(-40deg);
  }
}

@-webkit-keyframes scaleMouthSinging {

  0%,
  100%,
  20%,
  80%,
  60% {
    transform: scaleY(0);
  }

  30%,
  70%,
  75% {
    transform: scaleY(0.5);
  }

  10%,
  15% {
    transform: scaleY(1);
  }

  50%,
  55%,
  90%,
  95% {
    transform: scaleY(1.5);
  }
}

@keyframes scaleMouthSinging {

  0%,
  100%,
  20%,
  80%,
  60% {
    transform: scaleY(0);
  }

  30%,
  70%,
  75% {
    transform: scaleY(0.5);
  }

  10%,
  15% {
    transform: scaleY(1);
  }

  50%,
  55%,
  90%,
  95% {
    transform: scaleY(1.5);
  }
}

@-webkit-keyframes rotateDance {

  0%,
  50%,
  100% {
    transform: rotateY(0deg);
  }

  25% {
    transform: rotateY(5deg) rotate(2deg) translateY(-2px);
  }

  75% {
    transform: rotateY(-5deg) rotate(-2deg) translateY(-2px);
  }
}

@keyframes rotateDance {

  0%,
  50%,
  100% {
    transform: rotateY(0deg);
  }

  25% {
    transform: rotateY(5deg) rotate(2deg) translateY(-2px);
  }

  75% {
    transform: rotateY(-5deg) rotate(-2deg) translateY(-2px);
  }
}

@-webkit-keyframes rotateNotes {

  0%,
  50%,
  100% {
    transform: rotate(0deg);
  }

  25% {
    transform: rotate(-20deg);
  }

  75% {
    transform: rotate(20deg);
  }
}

@keyframes rotateNotes {

  0%,
  50%,
  100% {
    transform: rotate(0deg);
  }

  25% {
    transform: rotate(-20deg);
  }

  75% {
    transform: rotate(20deg);
  }
}

@-webkit-keyframes blinky {

  0%,
  9%,
  11%,
  19%,
  21%,
  69%,
  71%,
  100% {
    transform: scaleY(1);
  }

  10%,
  20%,
  70% {
    transform: scaleY(0.1);
  }
}

@keyframes blinky {

  0%,
  9%,
  11%,
  19%,
  21%,
  69%,
  71%,
  100% {
    transform: scaleY(1);
  }

  10%,
  20%,
  70% {
    transform: scaleY(0.1);
  }
}
</style>