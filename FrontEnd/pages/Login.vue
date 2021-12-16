<template>
  <b-container>
    <b-row
      class="mt-5 text-center d-flex justify-content-center"
      align-v="center"
    >
      <b-col cols="5" class="">
        <fa :icon="['fa', 'eraser']" size="10x" />

        <b-input-group prepend="Username" class="my-3">
          <b-form-input></b-form-input>
        </b-input-group>
        <b-input-group prepend="Password" class="my-3">
          <b-form-input></b-form-input>
        </b-input-group>
        <a class="ml-3"
          ><b-button pill variant="outline-success" class="px-5" size="lg"
            >Log In</b-button
          ></a
        >
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
  layout: 'Navbar',
}
</script>

<style>
</style>